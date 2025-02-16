package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTest {
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 5 / 0;
        });
    }
}