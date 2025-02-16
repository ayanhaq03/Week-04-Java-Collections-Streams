package junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class ParameterizedTestTest {

    @Test
    void isEvenTest() {
        int number=6;
        assertEquals(number % 2 == 0, ParameterizedTest.isEven(number));
    }
}