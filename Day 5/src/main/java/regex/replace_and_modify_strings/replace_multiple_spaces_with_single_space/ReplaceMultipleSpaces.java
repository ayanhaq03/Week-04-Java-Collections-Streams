package regex.replace_and_modify_strings.replace_multiple_spaces_with_single_space;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        // Example text with multiple spaces
        String text = "This   is   an    example  with   multiple   spaces.";

        // Call method to replace multiple spaces
        String result = replaceMultipleSpaces(text);

        // Print the modified text
        System.out.println(result);
    }

    public static String replaceMultipleSpaces(String text) {
        // Replace multiple spaces with a single space
        return text.replaceAll("\\s+", " ");
    }
}
