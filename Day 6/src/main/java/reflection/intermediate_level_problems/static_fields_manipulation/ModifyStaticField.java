package reflection.intermediate_level_problems.static_fields_manipulation;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static void printAPIKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get the class
            Class<?> configClass = Configuration.class;

            // Get the private static field 'API_KEY'
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make it accessible
            apiKeyField.setAccessible(true);

            // Modify the static field value
            apiKeyField.set(null, "NEW_SECRET_KEY");

            // Print modified value
            Configuration.printAPIKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}