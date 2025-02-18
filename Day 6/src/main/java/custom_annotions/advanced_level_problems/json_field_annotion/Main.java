package custom_annotions.advanced_level_problems.json_field_annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();  // The custom JSON key name
}

// User class with annotated fields
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    // Constructor
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}

// JSON Serializer class to handle object-to-JSON conversion
class JsonSerializer {

    // Method to convert an object to a JSON string based on @JsonField annotations
    public static String toJson(Object obj) {
        Map<String, Object> jsonMap = new HashMap<>();

        // Iterate over all fields in the object class
        for (Field field : obj.getClass().getDeclaredFields()) {
            // Check if the field has the @JsonField annotation
            if (field.isAnnotationPresent(JsonField.class)) {
                // Retrieve the annotation and custom name
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();

                // Make the field accessible and get its value
                field.setAccessible(true);
                try {
                    jsonMap.put(jsonKey, field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Convert the map to JSON format
        StringBuilder jsonBuilder = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            jsonBuilder.append("\"")
                    .append(entry.getKey())
                    .append("\": \"")
                    .append(entry.getValue())
                    .append("\", ");
        }

        // Remove the trailing comma and space
        if (jsonBuilder.length() > 1) {
            jsonBuilder.delete(jsonBuilder.length() - 2, jsonBuilder.length());
        }

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a User object
        User user = new User("john_doe", 25);

        // Convert the User object to JSON using custom serialization
        String json = JsonSerializer.toJson(user);

        // Print the resulting JSON string
        System.out.println(json);
    }
}