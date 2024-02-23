package jsonplaceholder.helpers;

import framework.PropertyReader;

import java.util.Properties;

public class PropertyConfig extends PropertyReader {
    private static Properties properties;

    public static Properties loadProperties(String pathToPropertiesFile) {
        properties = initProperty(pathToPropertiesFile);
        return properties;
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
}
