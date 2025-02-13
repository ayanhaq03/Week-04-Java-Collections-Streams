package count_word_in_file;


import java.io.*;
        import java.util.*;

public class countWords {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/count_word_in_file/words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        wordCount.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
