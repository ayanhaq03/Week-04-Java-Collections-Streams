package junit.advancedproblems;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class PasswordValidatorTest {

    @Test
    void isValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("StrongPass1"));
    }

    @Test
    void InvalidPasswordLength() {
        assertFalse(PasswordValidator.isValidPassword("Weak1"));
    }

    @Test
    void InvalidPasswordNoDigit() {
        assertFalse(PasswordValidator.isValidPassword("WeakPassword"));
    }
}