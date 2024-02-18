package jsonplaceholder.helpers;

import framework.FileLoader;

import java.util.Properties;

public class PropertyConfig extends FileLoader {
    private static Properties properties;

    public static Properties loadProperties(String pathToPropertiesFile) {
        properties = FileLoader.initProperty(pathToPropertiesFile);
        return properties;
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
}
