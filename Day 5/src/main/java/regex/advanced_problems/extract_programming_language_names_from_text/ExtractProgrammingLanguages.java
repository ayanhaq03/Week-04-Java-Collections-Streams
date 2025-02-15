package regex.advanced_problems.extract_programming_language_names_from_text;

import java.util.regex.*;
import java.util.*;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        // Example text containing programming languages
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Call method to extract programming languages
        List<String> languages = extractLanguages(text);

        // Print extracted languages
        System.out.println(languages);
    }

    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();

        // Regular expression to match programming language names
        Pattern pattern = Pattern.compile("\\b(Java|Python|JavaScript|Go|C\\+\\+|C|Ruby|Swift)\\b");
        Matcher matcher = pattern.matcher(text);

        // Find and store all matching language names
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }
}
