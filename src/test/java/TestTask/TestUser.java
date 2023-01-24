package TestTask;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@UtilityClass
public class TestUser {

    public static User normalUser;

    private static String testEmail = "mvin77@mail.ru";
    private static String testPassword = "test123456!";

    @SneakyThrows
    public static void initializeUsers() {

        Map <String, String> map = new HashMap<>();
        map.put(testEmail, testPassword);
        List<Map<String, String>> users = new LinkedList<>();
        users.add(map);

        normalUser = new User(users.get(0));
    }
}

