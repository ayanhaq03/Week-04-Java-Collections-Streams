package regex.extraction_problems.extract_link_from_webpage;

import java.util.regex.*;
import java.util.*;

public class ExtractLinks {
    public static void main(String[] args) {
        // Example text containing URLs
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Call method to extract links
        List<String> links = extractLinks(text);

        // Print extracted links
        System.out.println(links);
    }

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();

        // Regular expression to match URLs
        Pattern pattern = Pattern.compile("(https?://[\\w.-]+)");
        Matcher matcher = pattern.matcher(text);

        // Find and store all URL matches
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}
