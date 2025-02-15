package regex.extraction_problems.extract_all_capital_word_from_sentence;
import java.util.regex.*;
import java.util.*;

public class ExtractCapitalizedWords {
    public static void main(String[] args) {
        // Example sentence with capitalized words
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Call method to extract capitalized words
        List<String> words = extractCapitalizedWords(text);

        // Print extracted words
        System.out.println(words);
    }

    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();

        // Regular expression to match capitalized words
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        // Find and store all matches
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
