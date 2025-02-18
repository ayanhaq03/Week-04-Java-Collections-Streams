package reflection.advanced_level_problems.custom_object_mapper;

import java.lang.reflect.Field;
import java.util.Map;

class User {
    private String name;
    private int age;

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            } catch (NoSuchFieldException e) {
                // Ignore fields that do not exist
            }
        }

        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> userData = Map.of("name", "Alice", "age", 25);
        User user = toObject(User.class, userData);
        user.display();
    }
}