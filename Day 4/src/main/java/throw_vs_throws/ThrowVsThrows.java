package throw_vs_throws;
import java.util.*;

public class ThrowVsThrows {

    // Method to check for Exception
    public static void calculateInterest(double amount, double rate, double year) throws IllegalArgumentException {

        // Checking if Amount or Rate are Non-Negative
        if(amount < 0 || rate < 0) {
            throw new IllegalArgumentException();
        }

        // Else Calculating Interest
        double newamount = amount;
        while(year-- > 0) {
            newamount += (newamount*rate)/100;
        }

        // Printing the Interest amount
        System.out.println("Interest Amount : " + (newamount-amount));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking amount, rate and years from the user
        System.out.println("Enter Amount, Rate and Years : ");
        double amount = input.nextDouble();
        double rate = input.nextDouble();
        double years = input.nextDouble();

        // Calling method in try block
        try {
            calculateInterest(amount, rate, years);
        }
        catch(IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}