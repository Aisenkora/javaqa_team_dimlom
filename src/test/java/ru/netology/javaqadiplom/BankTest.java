package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BankTest {

    @Test
    public void shouldTransfer() {
        Account from = new Account();
        from.balance = 2_000;
        Account to = new Account();
        to.balance = 1_000;
        Bank bank = new Bank();
        bank.transfer(from, to, 100);

        int expectedFrom = 1_900;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 1_100;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }

    @Test
    public void shouldNotTransferIfAmountZero() {
        Account from = new Account();
        from.balance = 2_000;
        Account to = new Account();
        to.balance = 1_000;
        Bank bank = new Bank();
        bank.transfer(from, to, 0);

        int expectedFrom = 2_000;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 1_000;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }
    @Test
    public void shouldNotTransferIfAmountNegative() {
        Account from = new Account();
        from.balance = 2_000;
        Account to = new Account();
        to.balance = 1_000;
        Bank bank = new Bank();
        bank.transfer(from, to, -100);

        int expectedFrom = 2_000;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 1_000;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }

    @Test
    public void shouldNotTransferIfAmountNegativeOne() {
        Account from = new Account();
        from.balance = 2_000;
        Account to = new Account();
        to.balance = 1_000;
        Bank bank = new Bank();
        bank.transfer(from, to, -1);

        int expectedFrom = 2_000;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 1_000;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }
    @Test
    public void shouldTransferIfAmountEqualsBalanceFrom() {
        Account from = new Account();
        from.balance = 2_000;
        Account to = new Account();
        to.balance = 1_000;
        Bank bank = new Bank();
        bank.transfer(from, to, 2_000);

        int expectedFrom = 0;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 3_000;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }

    @Test
    public void shouldTransferIfAmountEqualsBalanceFromPlusOne() {
        Account from = new Account();
        from.balance = 2_000;
        Account to = new Account();
        to.balance = 1_000;
        Bank bank = new Bank();
        bank.transfer(from, to, 2_001);

        int expectedFrom = 2_000;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 1_000;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }
    @Test
    public void shouldNotTransferIfAmountMoreThanBalanceFrom() {
        Account from = new Account();
        from.balance = 2_000;
        Account to = new Account();
        to.balance = 1_000;
        Bank bank = new Bank();
        bank.transfer(from, to, 3_000);

        int expectedFrom = 2_000;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 1_000;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }
}


