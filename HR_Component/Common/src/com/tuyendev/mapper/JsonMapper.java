package com.tuyendev.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.common.collect.Lists;

import com.tuyendev.fw.BaseDTO;

import java.io.File;

import java.net.URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @tuyendev
 * See more about Jackson2 : https://github.com/FasterXML/jackson
 */
public class JsonMapper {

    private final static Logger logger = Logger.getGlobal();
    private final static ObjectMapper mapper = new ObjectMapper();

    public static <T> T jsonToObject(URL url, Class<T> cl) {
        T desc = null;
        try {
            return mapper.readValue(url, cl);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return desc;
    }

    public static <T> T jsonToObject(File file, Class<T> cl) {
        T desc = null;
        try {
            desc = mapper.readValue(file, cl);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return desc;
    }

    public static <T> T jsonToObject(String source, Class<T> cl) {
        T desc = null;
        try {
            desc = mapper.readValue(source, cl);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return desc;
    }

    public static <T> List<T> jsonToList(TypeReference<List<T>> type,String source) {
        try {
            return mapper.readValue(source, type);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return new ArrayList<>();
    }

    public static <T> List<T> jsonToList(TypeReference<List<T>> type,File source) {
        try {
            return  mapper.readValue(source, type);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return new ArrayList<>();
    }

    public static <T> List<T> jsonToList(TypeReference<List<T>> type, URL source) {
        try {
            return mapper.readValue(source, type);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return new ArrayList<>();
    }

    public static <K, V> Map<K, V> jsonToMap(TypeReference<Map<K, V>> type, String source) {
        try {
            return mapper.readValue(source,type);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return new HashMap<K,V>();
    }

    public static <K, V> Map<K, V> jsonToMap(TypeReference<Map<K, V>> type,URL source) {
        try {
            return mapper.readValue(source, type);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return new HashMap<K,V>();
    }

    public static <K, V> Map<K, V> jsonToMap(TypeReference<Map<K, V>> type,File source) {
        try {
            return mapper.readValue(source, type);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return new HashMap<K,V>();
    }

    public static <T> String objectToJson(T t) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return "";
    }


}
