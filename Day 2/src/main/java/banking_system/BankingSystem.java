package banking_system;

import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void processWithdrawal(String accountNumber) {
        withdrawalQueue.add(accountNumber);
    }

    public void executeWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String account = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + account);
        }
    }

    public void displayAccounts() {
        System.out.println("Accounts: " + accounts);
        System.out.println("Sorted Accounts: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("123", 5000);
        bank.addAccount("456", 10000);
        bank.addAccount("789", 2000);

        bank.processWithdrawal("123");
        bank.processWithdrawal("789");
        bank.executeWithdrawals();

        bank.displayAccounts();
    }
}
