package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    
    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("test.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test.properties", e);
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}