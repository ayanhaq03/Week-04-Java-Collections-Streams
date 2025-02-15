package regex.replace_and_modify_strings.censor_bad_word_in_sentence;
public class CensorBadWords {
    public static void main(String[] args) {
        // Example sentence with bad words
        String text = "This is a damn bad example with some stupid words.";

        // List of bad words to censor
        String[] badWords = {"damn", "stupid"};

        // Call method to censor bad words
        String result = censorBadWords(text, badWords);

        // Print censored sentence
        System.out.println(result);
    }

    public static String censorBadWords(String text, String[] badWords) {
        // Replace each bad word with "****"
        for (String word : badWords) {
            text = text.replaceAll("(?i)" + word, "****");
        }
        return text;
    }
}
