package regex.extraction_problems.extract_all_email_from_text;
import java.util.regex.*;
import java.util.*;

public class ExtractEmails {
    public static void main(String[] args) {
        // Example text containing email addresses
        String text = "Contact us at support@example.com and info@company.org";

        // Call the method to extract emails
        List<String> emails = extractEmails(text);

        // Print the extracted emails
        System.out.println(emails);
    }

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();

        // Regular expression to match email addresses
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);

        // Find and store all email matches
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}
