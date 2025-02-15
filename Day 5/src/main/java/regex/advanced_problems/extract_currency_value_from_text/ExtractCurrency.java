package regex.advanced_problems.extract_currency_value_from_text;

import java.util.regex.*;
import java.util.*;

public class ExtractCurrency {
    public static void main(String[] args) {
        // Example text containing currency values
        String text = "The price is $45.99, and the discount is 10.50.";

        // Call method to extract currency values
        List<String> values = extractCurrencyValues(text);

        // Print extracted currency values
        System.out.println(values);
    }

    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();

        // Regular expression to match currency values (with or without $ sign)
        Pattern pattern = Pattern.compile("\\$?\\d+(\\.\\d{2})?");
        Matcher matcher = pattern.matcher(text);

        // Find and store all currency values
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }
}
