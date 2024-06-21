package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000 , account.getBalance());
    }





    @Test
    public void shouldAddMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThenMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddIfAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-3_000);

        Assertions.assertEquals(2_000 , account.getBalance());
    }

    @Test
    public void shouldReduceInitialBalanceIfBalanceMoreThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500 , account.getBalance());
    }

    @Test
    public void shouldReduceInitialBalanceIfBalanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000 , account.getBalance());
    }

    @Test
    public void shouldReduceInitialBalanceIfBalanceLessMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_500);

        Assertions.assertEquals(2_000 , account.getBalance());
    }

    @Test
    public void shouldReduceIfAmountMoreThanBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_500);

        Assertions.assertEquals(2_000 , account.getBalance());
    }

    @Test
    public void shouldNotReduceInitialBalanceIfAmountZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2_000 , account.getBalance());
    }

    @Test
    public void shouldReduceIfAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-500);

        Assertions.assertEquals(2_000 , account.getBalance());
    }





    @Test
    public void shouldGetMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(1_000 , account.getMinBalance());

    }

    @Test
    public void shouldGetMinBalanceZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );
        Assertions.assertEquals(0 , account.getMinBalance());

    }

    @Test
    public void shouldGetMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(10_000 , account.getMaxBalance());

    }

    @Test
    public void shouldThrowExceptionRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1_000,
                    500,
                    10_000,
                    -5
            );
        });

        String expected = "Накопительная ставка не может быть отрицательной, а у вас: -5";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetRateZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );
        Assertions.assertEquals(0 , account.yearChange());

    }




    @Test
    public void shouldCalculatePercent() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5);

        account.add(1_200);

        Assertions.assertEquals(110 , account.yearChange());
    }

    @Test
    public void shouldRoundPercent() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5);

        account.add(1_217);

        Assertions.assertEquals(60 , account.yearChange());
    }

    @Test
    public void shouldCalculatePercentIfAddLess100() {
        SavingAccount account = new SavingAccount(
                20,
                20,
                10_000,
                5);

        account.add(25);

        Assertions.assertEquals(2 , account.yearChange());
    }

    @Test
    public void shouldCalculatePercentIfAddLess100BalanceZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5);

        account.add(99);

        Assertions.assertEquals(4 , account.yearChange());
    }

    @Test
    public void shouldCalculateIfAmountPercentLessOne() {
        SavingAccount account = new SavingAccount(
                20,
                20,
                10_000,
                1);

        account.add(25);

        Assertions.assertEquals(0 , account.yearChange());
    }

    @Test
    public void shouldCalculateIfAmountPercentOne() {
        SavingAccount account = new SavingAccount(
                50,
                50,
                10_000,
                1);

        account.add(50);

        Assertions.assertEquals(1 , account.yearChange());
    }

    @Test
    public void shouldCalculateIfAmountPercentMoreOne() {
        SavingAccount account = new SavingAccount(
                50,
                50,
                10_000,
                1);

        account.add(51);

        Assertions.assertEquals(1 , account.yearChange());
    }

    @Test
    public void shouldCalculatePercentIfBalanceMoreMaxBalance() {
        SavingAccount account = new SavingAccount(
                9_500,
                1_000,
                10_000,
                5);

        account.add(595);


        Assertions.assertEquals(475 ,  account.yearChange());
    }

    @Test
    public void shouldCalculatePercentIfBalanceZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5);



        Assertions.assertEquals(0 ,  account.yearChange());
    }





    @Test
    public void shouldThrowExceptionMinBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1_000,
                    -1_000,
                    10_000,
                    5);
        });

        String expected = "Минимальный баланс не может быть отрицательным, а у вас: -1000";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -1_000,
                    500,
                    10_000,
                    5);
        });

        String expected = "Начальный баланс не может быть меньше минимального";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionMinAndMaxBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    11_000,
                    10_000,
                    5_000,
                    5);
        });

        String expected = "Минимальный  баланс не может быть больше или равен максимальному";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionMinEqualMaxBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    17_000,
                    10_000,
                    10_000,
                    5);
        });

        String expected = "Минимальный  баланс не может быть больше или равен максимальному";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }



}
