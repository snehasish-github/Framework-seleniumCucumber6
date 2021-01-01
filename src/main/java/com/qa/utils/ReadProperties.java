package com.qa.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {

    private static Properties properties=new Properties();

    private ReadProperties() {
    }

    static {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                    System.getProperty("file.separator") + "/src/test/resources" +
                    System.getProperty("file.separator") + "config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperties(String key) {

        if (key == null || properties.getProperty(key) == null)
            try {
                throw new Exception("Property " + key + " is not present in config.properties file");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return properties.getProperty(key);
    }
}
