package junit.advancedproblems;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void withdraw() {
        BankAccount account = new BankAccount(200);
        assertTrue(account.withdraw(100));
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawFail() {
        BankAccount account = new BankAccount(50);
        assertFalse(account.withdraw(100)); // Should fail due to insufficient funds
    }
}