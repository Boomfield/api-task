package framework;

import java.util.UUID;

public class CommonFunctions {
    public static String generateRandomString() {
        return UUID.randomUUID().toString();
    }
}