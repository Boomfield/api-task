package jsonplaceholder.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import jsonplaceholder.models.User;
import framework.FileLoader;

import java.util.List;
import java.util.Optional;

public class PropertyUsers extends FileLoader{
    private static List<User> users;

    public static void loadUsersJsonFile(String pathToJsonFile) {
        users = readJsonFile(pathToJsonFile, new TypeReference<>() {});
    }

    public static User getUserById(int userId) {
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst();

        return userOptional.orElseThrow(() -> new IllegalArgumentException(String.format("User with id %d not found.", userId)));
    }
}
