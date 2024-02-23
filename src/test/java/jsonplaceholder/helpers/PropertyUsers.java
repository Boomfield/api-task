package jsonplaceholder.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import framework.JsonReader;
import jsonplaceholder.models.User;

import java.util.List;
import java.util.Optional;

public class PropertyUsers extends JsonReader {
    private static List<User> users;

    public static void loadUsersJsonFile(String pathToJsonFile) {
        users = initJson(pathToJsonFile, new TypeReference<>() {});
    }

    public static User getUserById(int userId) {
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst();

        return userOptional.orElseThrow(() -> new IllegalArgumentException(String.format("User with id %d not found.", userId)));
    }
}
