package bank_transaction_system;

// Custom Exception class
class InsufficientBalanceException extends Exception {

    // Constructor
    InsufficientBalanceException() {
        super("Insufficient balance!");
    }
}

public class BankTransactionSystem {

    public static double withdraw(double amount, double towithdraw) throws InsufficientBalanceException, IllegalArgumentException {

        // Checking if the withdrawing amount is negative
        if(towithdraw < 0) {
            throw new IllegalArgumentException();
        }

        // Checking insufficient balance condition
        if(towithdraw > amount) {
            throw new InsufficientBalanceException();
        }

        System.out.println("Done");
        return amount-towithdraw;
    }
    public static void main(String[] args) {

        // Calling withdraw method
        double amount = 1000;
        try {
            amount = withdraw(100, -46);
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        }
    }
}
