package com.tuyendev.gendto;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenDTO {

    private static String classPath;
    private static String entityPackage;
    private static String dtoPackage;

    public static void main(String[] args) {
        classPath = "C:\\Dev\\GenDTOs\\src\\input";
        entityPackage = "";
        dtoPackage = "";
        doAction();
    }


    private static void doAction() {
        try {
            File folder = new File(classPath);
            List<File> result = getAllFilesInFolder(folder);
            URL url = folder.toURI().toURL();
            URL[] urls = new URL[]{url};
            List<Class> classes = new ArrayList<>();
            List<String> classType = new ArrayList<>();
            ClassLoader classLoader = new URLClassLoader(urls);
            for (File file : result) {
                Class cl = addFileIntoClassLoader(classLoader, file);
                if (cl != null) {
                    classes.add(cl);
                    classType.add(cl.getTypeName());
                }
            }
            for (Class cl : classes) {
                writeDTO(cl, dtoPackage, classType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeDTO(Class cl, String dtoPackage, List<String> classesType) throws IOException {
        Field[] fields = cl.getDeclaredFields();
        Map<String, String> variables = new HashMap<>();
        List<String> imports = new ArrayList<>();
        for (Field f : fields) {
            String type = f.getGenericType().getTypeName();
            String param = f.getName();
            if (type.contains("java.lang")) {
                type = type.replace("java.lang.", "");
                variables.put(param, type);
            } else if (type.contains("java.math")) {
                imports.add(type);
                variables.put(param, type.replace("java.math.", ""));
            } else if (type.contains("java.util")) {
                imports.add("java.util.*");
                type = type.replace("java.util.", "");
                String dtoType = null;
                if (type.contains(entityPackage)) {
                    String entityType = getEntity(type, classesType);
                    dtoType = type.replace(entityPackage + "." + entityType, entityType + "DTO");
                }
                variables.put(param, dtoType == null ? type : dtoType);

            } else if (type.contains("java.sql")) {
                imports.add(type);
                variables.put(param, type.replace("java.sql.", ""));
            } else if (type.contains(entityPackage)) {
                variables.put(param, type.replace(entityPackage + ".", "") + "DTO");
            }

        }
        imports = imports.stream().distinct().collect(Collectors.toList());
        String path = "src\\\\" +
                "" + dtoPackage.replace(".", "\\\\");
        String className = cl.getCanonicalName().replace(entityPackage, "").replaceFirst("\\.", "");
        String newFile = path + "\\\\" + className + "DTO.java";
        Path path2 = Paths.get(path);
        Files.createDirectories(path2);
        try (FileWriter fw = new FileWriter(newFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("package " + dtoPackage + ";\n");
            out.println("import java.io.Serializable;");
            for (String im : imports) {
                out.println("import " + im + ";");
            }

            out.println("\npublic class " + className + "DTO implements Serializable {\n");
            out.println("\t//VARIABLES");
            variables.forEach((key, value) -> {
                out.println("\tprivate " + value + " " + key + ";");
            });
            out.println("\n\t//GETTER-SETTER");
            variables.forEach((key, value) -> {
                out.println("\tpublic " + value + " get" + upperFirst(key) + "() {");
                out.println("\t\treturn this." + key + ";");
                out.println("\t}\n");

                out.println("\tpublic void set" + upperFirst(key) + "(" + value + " " + key + ") {");
                out.println("\t\tthis." + key + " = " + key + ";");
                out.println("\t}\n");
            });

            out.println("}");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getTextBetweenParentheses(String lang){
        int start = lang.indexOf("<");
        int end = lang.indexOf(">");
        if(end == -1) return lang;
        return lang.substring(start+1,end);
    }

    private static String upperFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    private static String getEntity(String type, List<String> types) {
        String dtoType = null;
        for (String s : types) {
            if (getTextBetweenParentheses(type).equals(s)) {
                dtoType = s.replace(entityPackage + ".", "");
                break;
            }

        }
        return dtoType;
    }

    private static Class addFileIntoClassLoader(ClassLoader cl, File file) {
        try {
            String classPath = entityPackage + "." + file.getName().replace(".class", "");
            return cl.loadClass(classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<File> getAllFilesInFolder(File folder) {
        File[] listOfFiles = folder.listFiles();
        List<File> result = new ArrayList<>();
        if (listOfFiles == null || listOfFiles.length == 0) {
            return result;
        } else {
            for (File temp : listOfFiles) {
                if (temp.isFile()) {
                    if (temp.getName().contains(".class")) {
                        result.add(temp);
                    }
                } else if (temp.isDirectory()) {
                    result.addAll(getAllFilesInFolder(temp));
                }
            }
        }
        return result;

    }
}

