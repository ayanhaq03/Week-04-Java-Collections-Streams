package try_with_resources;
import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {

        // Creating try block
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/main/java/try_with_resources/info.txt"))) {

            // Printing the first line of the Text File
            System.out.print("The first line of the file \"info.txt\" : ");
            System.out.println(buffer.readLine());
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}