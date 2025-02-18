package reflection.advanced_level_problems.json_representation;

import java.lang.reflect.Field;

class Person {
    private String name = "John";
    private int age = 30;
}

public class JsonGenerator {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\": \"")
                    .append(field.get(obj)).append("\", ");
        }

        if (fields.length > 0) json.setLength(json.length() - 2); // Remove last comma
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        System.out.println(toJson(person));
    }
}