package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class FileProcessorTest {
    FileProcessor fileProcessor = new FileProcessor();
    String filename = "test.txt";

    @Test
    void writeToFile() throws IOException {
        fileProcessor.writeToFile(filename, "Hello World");
    }

    @Test
    void readFromFile() throws IOException {
        assertEquals("Hello World", fileProcessor.readFromFile(filename));
    }
}