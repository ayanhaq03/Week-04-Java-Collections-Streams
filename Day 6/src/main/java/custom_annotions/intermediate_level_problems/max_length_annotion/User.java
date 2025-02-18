package custom_annotions.intermediate_level_problems.max_length_annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)  // This ensures the annotation is available at runtime
@interface MaxLength {
    int value();  // Define the value element that specifies the max length allowed
}

// User class with a username field that uses the @MaxLength annotation
public class User {
    private String username;

    // Constructor with validation
    public User(String username) {
        // Get the @MaxLength annotation applied to the field
        MaxLength maxLengthAnnotation = this.getClass().getDeclaredFields()[0].getAnnotation(MaxLength.class);

        if (maxLengthAnnotation != null) {
            // Get the maximum length from the annotation
            int maxLength = maxLengthAnnotation.value();

            // Validate the length of the username
            if (username.length() > maxLength) {
                throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength + " characters.");
            }
        }

        this.username = username;
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Main method to test the validation
    public static void main(String[] args) {
        try {
            User user = new User("thisusernameiswaytoolong");  // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}