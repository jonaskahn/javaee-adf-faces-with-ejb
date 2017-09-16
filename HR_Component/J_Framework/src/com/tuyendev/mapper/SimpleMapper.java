package com.tuyendev.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SimpleMapper<Entity, DTO> {

    private Logger logger = Logger.getGlobal();

    List<Object> objds = new ArrayList<>();
    List<Object> objsr = new ArrayList<>();
    Map<Integer, Object> mapObj = new HashMap<>();

    private final Class<Entity> src;
    private final Class<DTO> desc;

    public SimpleMapper(Class<Entity> src, Class<DTO> desc) {
        this.src = src;
        this.desc = desc;
    }


    public DTO entityToDTO(Entity entity) {
        DTO dto = null;
        try {
            dto = convertDTO(entity);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return dto;
    }

    public List<DTO> entityToDTO(List<Entity> entities) {
        List<DTO> dtos = new ArrayList<DTO>();
        try {
            for (Entity entity : entities) {
                dtos.add(convertDTO(entity));
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return dtos;
    }


    public Entity dtoToEntity(DTO dto) {
        Entity entity = null;
        try {
            entity = convertEntity(dto);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return entity;
    }

    public List<Entity> dtoToEntity(List<DTO> dtos) {
        List<Entity> entities = new ArrayList<Entity>();
        try {
            for (DTO dto : dtos) {
                entities.add(convertEntity(dto));
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return entities;
    }

    @SuppressWarnings("unchecked")
    private void convertFrom(Object src, Object desc) throws Exception {

        if (objsr.isEmpty() || !isInList(src, objsr)) {
            objsr.add(src);
            mapObj.put(System.identityHashCode(src), desc);
        }
        if (objds.isEmpty() || !isInList(desc, objds)) {
            objds.add(desc);
        }
        Map<String, Field> map_src_vars_fields =
            Arrays.stream(src.getClass().getDeclaredFields())
            .collect(Collectors.toMap(Field::getName, Function.identity()));


        Map<String, Field> map_desc_vars_fields =
            Arrays.stream(desc.getClass().getDeclaredFields())
            .collect(Collectors.toMap(Field::getName, Function.identity()));

        for (Map.Entry<String, Field> entry : map_src_vars_fields.entrySet()) {
            String var = entry.getKey();
            Field sf = entry.getValue();
            Field df = map_desc_vars_fields.get(var);
            sf.setAccessible(true);
            df.setAccessible(true);
            Object srcIntance = sf.get(src);
            if (srcIntance != null) {

                if (!Objects.equals(df.getType(), sf.getType())) {

                    Object newIntance;

                    if (objsr.isEmpty() || !isInList(srcIntance, objsr)) {
                        objsr.add(srcIntance);
                        newIntance = df.getType().newInstance();
                        mapObj.put(System.identityHashCode(srcIntance), newIntance);


                    } else {
                        newIntance = mapObj.get(System.identityHashCode(srcIntance));
                    }
                    df.set(desc, newIntance);
                    if (objds.isEmpty() || !isInList(newIntance, objds)) {
                        objds.add(newIntance);
                        convertFrom(srcIntance, newIntance);
                    }

                } else {

                    if (srcIntance instanceof Collection) {
                        Collection srcIntances = (Collection) srcIntance;
                        Class descClass = getTypeClass(df);
                        Object newIntance;
                        Collection newInstances = new ArrayList();
                        df.set(desc, newInstances);
                        for (Object srcIntanceIter : srcIntances) {
                            if (objsr.isEmpty() || !isInList(srcIntanceIter, objsr)) {
                                objsr.add(srcIntanceIter);
                                newIntance = descClass.newInstance();
                                mapObj.put(System.identityHashCode(srcIntanceIter), newIntance);
                            } else {
                                newIntance = mapObj.get(System.identityHashCode(srcIntanceIter));
                            }
                            if (newIntance != null) {
                                newInstances.add(newIntance);
                                if (objds.isEmpty() || !isInList(newIntance, objds)) {
                                    objds.add(newIntance);
                                    convertFrom(srcIntanceIter, newIntance);
                                }
                            }

                        }
                    } else {
                        df.set(desc, sf.get(src));
                    }
                }
            }
        }


    }

    private boolean isInList(Object o, List li) {
        for (Object ob : li) {
            if (Objects.equals(System.identityHashCode(ob), System.identityHashCode(o))) {
                return true;
            }
        }
        return false;
    }

    private DTO convertDTO(Entity source) throws Exception {
        DTO de = desc.newInstance();
        convertFrom(source, de);
        return de;
    }

    private Entity convertEntity(DTO source) throws Exception {
        Entity de = src.newInstance();
        convertFrom(source, de);
        return de;
    }

    private Class getTypeClass(Field field) {
        ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
        return (Class<?>) stringListType.getActualTypeArguments()[0];
    }
}
