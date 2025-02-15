package regex.advanced_problems.validate_social_security_number;

import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        // Example SSN numbers
        String ssn1 = "123-45-6789";
        String ssn2 = "123456789";

        // Validate SSNs
        System.out.println(validateSSN(ssn1) ? "✅ \"" + ssn1 + "\" is valid" : "❌ \"" + ssn1 + "\" is invalid");
        System.out.println(validateSSN(ssn2) ? "✅ \"" + ssn2 + "\" is valid" : "❌ \"" + ssn2 + "\" is invalid");
    }

    public static boolean validateSSN(String ssn) {
        // Regular expression for a valid SSN (format: XXX-XX-XXXX)
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return ssn.matches(regex);
    }
}
