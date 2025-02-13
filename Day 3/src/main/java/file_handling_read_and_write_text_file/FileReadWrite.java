package file_handling_read_and_write_text_file;


import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        File sourceFile = new File("src\\main\\java\\file_handling_read_and_write_text_file/source.txt");
        File destFile = new File("src\\main\\java\\file_handling_read_and_write_text_file/destination.txt");

        // Check if source file exists
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
