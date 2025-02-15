package regex.advanced_problems.validate_an_ip_address;

import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        // Example IP address
        String ip = "192.168.1.1";

        // Call method to validate IP address
        boolean isValid = validateIPAddress(ip);

        // Print validation result
        System.out.println(isValid ? "Valid IP" : "Invalid IP");
    }

    public static boolean validateIPAddress(String ip) {
        // Regular expression to match IPv4 addresses
        String regex = "\\b((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\b";

        // Check if the given IP matches the regex
        return ip.matches(regex);
    }
}
