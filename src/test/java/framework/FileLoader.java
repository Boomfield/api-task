package framework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class FileLoader {
    public static Properties initProperty(String pathToPropertiesFile) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(pathToPropertiesFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static <T> T readJsonFile(String filePath, TypeReference<T> valueTypeRef) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), valueTypeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
