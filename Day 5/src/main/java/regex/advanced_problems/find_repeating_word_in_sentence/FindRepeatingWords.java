package regex.advanced_problems.find_repeating_word_in_sentence;

import java.util.regex.*;
import java.util.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        // Example sentence with repeating words
        String text = "This is is a repeated repeated word test.";

        // Call method to find repeating words
        Set<String> repeatingWords = findRepeatingWords(text);

        // Print the repeating words
        System.out.println(repeatingWords);
    }

    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeatingWords = new HashSet<>();
        Set<String> seenWords = new HashSet<>();

        // Regular expression to match words
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
        Matcher matcher = pattern.matcher(text);

        // Check for repeating words
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (!seenWords.add(word)) {
                repeatingWords.add(word);
            }
        }
        return repeatingWords;
    }
}
