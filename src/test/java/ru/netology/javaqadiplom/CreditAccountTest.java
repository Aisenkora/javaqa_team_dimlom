package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldIncreaseBalanceifAmountValid() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        account.add(500);

        int expected = 1_500;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseBalanceifAmountInvalid() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        account.add(-500);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotChangeBalanceIfAddZero() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        account.add(0);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDescreaseBalanceifBalanceMoreThanAmount() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        account.pay(500);

        int expected = 500;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDescreaseBalalanceIfAmountMoreThanBalance() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        account.pay(2_000);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculatePercent() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        account.pay(1_200);

        int expected = -30;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDescreaseBalanceBelowCreditLimit() {
        CreditAccount account = new CreditAccount(0, 1_000, 15);

        account.pay(1_100);

        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotChangeBalanceIfPayZero() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        account.pay(0);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCalculatePercent() {
        CreditAccount account = new CreditAccount(300, 500, 15);

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCalculatePercentIfBalanceZero() {
        CreditAccount account = new CreditAccount(0, 500, 15);

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, 500, -5);
        });

        String expected = "Накопительная ставка не может быть отрицательной, а у вас: -5";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionCreditLimit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, -500, 15);
        });

        String expected = "Кредитный лимит не может быть отрицательным, а у вас: -500";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1_000, 500, 15);
        });

        String expected = "Начальный баланс не может быть отрицательным, а у вас: -1000";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCreditLimit() {
        CreditAccount account = new CreditAccount(1_000, 500, 15);

        int expected = 500;
        int actual = account.getCreditLimit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPercent() {
        CreditAccount account = new CreditAccount(1_000, 500, 80);

        account.pay(1_099);

        int expected = -79;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}