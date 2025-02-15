package regex.advanced_problems.validate_credit_card_number;
import java.util.regex.*;

public class ValidateCreditCard {
    public static void main(String[] args) {
        // Example Visa card number
        String cardNumber = "4111111111111111";

        // Call method to validate credit card number
        boolean isValid = validateCreditCard(cardNumber);

        // Print validation result
        System.out.println(isValid ? "Valid Credit Card" : "Invalid Credit Card");
    }

    public static boolean validateCreditCard(String cardNumber) {
        // Regular expression to match Visa (starting with 4) and MasterCard (starting with 5)
        return cardNumber.matches("^4\\d{15}|5[1-5]\\d{14}$");
    }
}
