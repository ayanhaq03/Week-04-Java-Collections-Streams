package junit.advancedproblems;

public class PasswordValidator {
    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
}
