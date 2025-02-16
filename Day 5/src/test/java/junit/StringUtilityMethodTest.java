package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilityMethodTest {
    StringUtilityMethod utils = new StringUtilityMethod();
    @Test
    void reverse() {
        assertEquals("cba", utils.reverse("abc"));
    }

    @Test
    void isPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void toUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }
}