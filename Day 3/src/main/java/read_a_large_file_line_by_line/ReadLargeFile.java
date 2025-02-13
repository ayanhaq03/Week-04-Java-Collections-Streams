package read_a_large_file_line_by_line;


import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        File file = new File("src/main/java/read_a_large_file_line_by_line/largefile.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
