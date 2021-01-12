package com.syntax.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    private static Properties properties;

    /**
     * This method reads any given properties file
     *
     * @param filePath
     * @return Properties
     */
    public static Properties readProperties(String filePath){

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        }
        catch (FileNotFoundException ex ) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        return  properties;
    }

    /**
     * This method retrieves single value based on specified key
     * @param key
     * @return
     */
    public static String getPropertyValue (String key){
        return properties.getProperty(key);
    }

}
