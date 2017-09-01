package com.tuyendev.bundle;

import com.tuyendev.utils.DataUtil;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.logging.Logger;

import java.text.MessageFormat;

import java.util.Arrays;

public class GetText {
    private final static Logger logger = Logger.getGlobal();
    private static Properties prop = getProperties();
    private static InputStream lang;
    private static InputStream lang_vi;

    private static Properties getProperties() {
        prop = new Properties();
        try {
            lang = GetText.class.getClassLoader().getResourceAsStream("com/tuyendev/key/lang.properties");
            prop.load(lang);
        } catch (IOException e) {
            logger.severe(e.getMessage());
            try {
                lang_vi = GetText.class.getClassLoader().getResourceAsStream("com/tuyendev/key/lang_vi.properties");
                prop.load(lang_vi);
            } catch (IOException f) {
                logger.severe(e.getMessage());
            }
        } finally {
            try {
                lang.close();
                lang_vi.close();
            } catch (Exception ex) {
            }
        }

        return prop;
    }

    public static String getKey(String key) {
        return prop.getProperty(key);
    }

    public static String getKey(String key, Object... params) {
        String message = prop.getProperty(key);
        if (!DataUtil.isNullOrEmpty(params)) {
            String[] values = Arrays.toString(params)
                                    .split("[\\[\\]]")[1]
                                    .split(", ");
            if (!DataUtil.isNullOrEmpty(values) && !DataUtil.isNullOrEmpty(message)) {
                message = MessageFormat.format(message, values);
            }
        }
        return message;

    }
}
