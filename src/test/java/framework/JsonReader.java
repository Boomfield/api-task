package framework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    public static <T> T initJson(String filePath, TypeReference<T> valueTypeRef) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), valueTypeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
