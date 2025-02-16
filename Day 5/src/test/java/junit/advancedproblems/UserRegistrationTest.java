package junit.advancedproblems;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class UserRegistrationTest {
    @Test
    void testValidUser() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("Jack Sparrow", "jack@example.com", "SecurePass123"));
    }

    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("", "jimmy@example.com", "SecurePass123"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("Jack Sparrow", "invalid-email", "SecurePass123"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("Jack Sparrow", "jack@example.com", "short"));
        assertEquals("Password must be at least 8 characters", exception.getMessage());
    }

}