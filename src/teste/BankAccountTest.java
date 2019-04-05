package teste;

import categorii.Deposit;
import categorii.Withdraw;
import clase.BankAccount;
import exceptii.ExceptieDepunere;
import exceptii.ExceptieRetragere;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BankAccountTest {

    BankAccount bankAccount;

    @Before
    public void setup() {
        bankAccount = new BankAccount(100, 50, 20);
    }

    @Test
    @Category(Withdraw.class)
    public void testRetragereRight() {
        bankAccount.withdraw(40);
        assertEquals("test", 60, bankAccount.getBalance(), 0.01);

    }

    @Test
    @Category(Withdraw.class)
    public void testRetragereBoundaryMin() {
        bankAccount.withdraw(1);
        assertEquals(99, bankAccount.getBalance(), 0.01);
    }

    @Test
    @Category(Withdraw.class)
    public void testRetragereBoundaryMax() {
        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance(), 0.01);
    }

    @Test
    @Category(Withdraw.class)
    public void testRetragereInverse() {
        double balanceInitial = bankAccount.getBalance();
        bankAccount.withdraw(30);
        assertEquals(balanceInitial, bankAccount.getBalance() + 30, 0.01);
    }

    @Test(expected = ExceptieRetragere.class)
    @Category(Withdraw.class)
    public void testRetragereError() {
        bankAccount.withdraw(120);
    }

    @Test(timeout = 10)
    @Category(Withdraw.class)
    public void testRetragerePerformance() {
        bankAccount.withdraw(40);
        System.out.println(bankAccount.getBalance());
    }


    @Test
    @Category(Deposit.class)
    public void testDepunereRight() {
        bankAccount.deposit(40);
        assertEquals(140, bankAccount.getBalance(), 0.01);

    }

    @Test
    @Category(Deposit.class)
    public void testDepunereBoundaryMin() {
        bankAccount.deposit(1);
        assertEquals( 101, bankAccount.getBalance(), 0.01);

    }

    @Test
    @Category(Deposit.class)
    public void testDepunereInverse() {
        double balanceInitial = bankAccount.getBalance();
        bankAccount.deposit(30);
        assertEquals(balanceInitial, bankAccount.getBalance() - 30, 0.01);
    }

    @Test(expected = ExceptieDepunere.class)
    @Category(Deposit.class)
    public void testDepunereError(){
        bankAccount.deposit(-5);
    }

    @Test(timeout = 10)
    @Category(Deposit.class)
    public void testDepunerePerformance() {
        bankAccount.deposit(40);
    }

}