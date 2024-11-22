package com.curaHealthcare.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderUtil {

    private static Properties properties;

    // Static block to initialize the properties from the config file
    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();  // Create a Properties object to hold the config data
            properties.load(fileInputStream);  // Load the properties from the file
        } catch (IOException e) {
            // Handle the exception if the config file cannot be loaded
            throw new RuntimeException("Failed to load configuration file.", e);
        }
    }

    // Static method to retrieve a property value by key
    public static String getProperty(String key) {
        String value = properties.getProperty(key);  // Get the property value for the provided key
        if (value == null) {
            // Throw an exception if the key is not found in the properties file
            throw new RuntimeException("Property with key '" + key + "' not found.");
        }
        return value;  // Return the property value
    }
}
