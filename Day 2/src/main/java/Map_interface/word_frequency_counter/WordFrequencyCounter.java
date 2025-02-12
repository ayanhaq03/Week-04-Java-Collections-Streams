package Map_interface.word_frequency_counter;


import java.util.*;

class WordFrequencyCounter {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-z ]", "");
        for (String word : text.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        System.out.println(countWords(text));
    }
}
