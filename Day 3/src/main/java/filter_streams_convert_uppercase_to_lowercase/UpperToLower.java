package filter_streams_convert_uppercase_to_lowercase;


import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        File inputFile = new File("src/main/java/filter_streams_convert_uppercase_to_lowercase/uppercase.txt");
        File outputFile = new File("src/main/java/filter_streams_convert_uppercase_to_lowercase/lowercase.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            System.out.println("File converted to lowercase successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
