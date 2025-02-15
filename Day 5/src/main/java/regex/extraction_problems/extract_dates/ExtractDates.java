package regex.extraction_problems.extract_dates;
import java.util.regex.*;
import java.util.*;

public class ExtractDates {
    public static void main(String[] args) {
        // Example text containing dates
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Call method to extract dates
        List<String> dates = extractDates(text);

        // Print extracted dates
        System.out.println(dates);
    }

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();

        // Regular expression to match dates in dd/mm/yyyy format
        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        // Find and store all date matches
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
}
