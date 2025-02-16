package junit.advancedproblems;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    @Test
    void testValidDate() {
        assertEquals("10-02-2024", DateFormatter.formatDate("2024-02-10"));
    }

    @Test
    void testInvalidDate() {
        assertEquals("Invalid date", DateFormatter.formatDate("2024-13-40"));
    }
}