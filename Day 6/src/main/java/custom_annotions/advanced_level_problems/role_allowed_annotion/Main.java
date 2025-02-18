package custom_annotions.advanced_level_problems.role_allowed_annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();  // Role required to access the method
}

// User class that simulates user roles
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Service class with methods that require role-based access
class UserService {

    // This method is accessible only by users with "ADMIN" role
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }

    // This method is accessible by any role
    public void viewUser() {
        System.out.println("User details viewed.");
    }
}

// AccessControl class to simulate checking role before invoking method
class AccessControl {

    public static void checkAccess(User user, Method method) {
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            // Get the required role for this method from the annotation
            String requiredRole = method.getAnnotation(RoleAllowed.class).value();

            // Check if the user's role matches the required role
            if (!user.getRole().equalsIgnoreCase(requiredRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }

        // If access is allowed or no restriction, invoke the method
        try {
            method.invoke(new UserService());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User regularUser = new User("USER");

        // Test with ADMIN user
        System.out.println("Test with ADMIN user:");
        try {
            Method deleteUserMethod = UserService.class.getMethod("deleteUser");
            AccessControl.checkAccess(adminUser, deleteUserMethod);  // Should be allowed
            AccessControl.checkAccess(regularUser, deleteUserMethod);  // Should be denied
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // Test with regular user
        System.out.println("\nTest with regular user:");
        try {
            Method viewUserMethod = UserService.class.getMethod("viewUser");
            AccessControl.checkAccess(regularUser, viewUserMethod);  // Should be allowed
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}