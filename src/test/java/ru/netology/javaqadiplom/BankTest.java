package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




public class BankTest {

        @Test
        public void shouldGetTransferFromCreditToSaving() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(500, 100, 1_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 500);
            int expectedFrom = 500;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldGetTransferFromSavingToCredit() {
            SavingAccount from = new SavingAccount(1_000, 100, 1000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 500);
            int expectedFrom = 500;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_500;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromSavingToCreditIfAmountZero() {
            SavingAccount from = new SavingAccount(1_000, 100, 1000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 0);
            int expectedFrom = 1_000;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromCreditToSavingIfAmountZero() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 1000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 0);
            int expectedFrom = 1_000;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldGetTransferFromCreditToSavingIfAmountOne() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 1);
            int expectedFrom = 999;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_001;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromSavingToCreditIfAmountOne() {
            SavingAccount from = new SavingAccount(1_000, 100, 1000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 1);
            int expectedFrom = 999;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_001;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldGetTransferFromCreditToSavingIfAmountEqualsFrom() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_000);
            int expectedFrom = 0;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 2_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromSavingToCreditIfAmountEqualsFrom() {
            SavingAccount from = new SavingAccount(1_000, 0, 1000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_000);
            int expectedFrom = 0;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 2_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }



        @Test
        public void shouldGetTransferFromCreditToSavingIfAfterFromEqualsCreditLimit() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_500);
            int expectedFrom = -500;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 2_500;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromSavingToCreditAfterFromEqualsMinBalance() {
            SavingAccount from = new SavingAccount(1_500, 500, 10_000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_000) ;
            int expectedFrom = 500;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 2_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }



        @Test
        public void
        shouldGetTransferFromCreditToSavingIfAfterFromMoreCreditLimitOnOne() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_501);
            int expectedFrom = 1_000;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void
        shouldGetTransferFromCreditToSavingIfAfterFromMoreCreditLimit() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 5_500);
            int expectedFrom = 1_000;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void
        shouldGetTransferFromCreditToSavingIfAfterFromLessCreditLimitOnOne() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_499);
            int expectedFrom = -499;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 2_499;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromSavingToCreditAfterFromMoreMinBalanceOnOne() {
            SavingAccount from = new SavingAccount(1_500, 500, 10_000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_001);
            int expectedFrom = 1_500;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromSavingToCreditAfterFromMoreMinBalance() {
            SavingAccount from = new SavingAccount(1_500, 500, 10_000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 5_000);
            int expectedFrom = 1_500;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void shouldNotGetTransferFromSavingToCreditIfAmountFromLessMinBalanceOnOne() {
            SavingAccount from = new SavingAccount(1_500, 500, 10_000, 5);
            CreditAccount to = new CreditAccount(1_000, 500, 10);
            Bank bank = new Bank();
            bank.transfer(from, to, 999);
            int expectedFrom =501;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_999;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }



        @Test
        public void shouldGetTransferFromCreditToSavingIfAfterFromIsNegativeOnOne() {
            CreditAccount from = new CreditAccount(1_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 1_001);
            int expectedFrom = -1;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 2_001;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void
        shouldGetTransferFromCreditToSavingIfAfterToEqualMaxBalance() {
            CreditAccount from = new CreditAccount(9_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 9_000);
            int expectedFrom = 0;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 10_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }



        @Test
        public void
        shouldGetTransferFromCreditToSavingIfAfterToLessMaxBalanceOnOne() {
            CreditAccount from = new CreditAccount(9_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 8_999);
            int expectedFrom = 1;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 9_999;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void
        shouldGetTransferFromCreditToSavingIfAfterToMoreMaxBalanceOnOne() {
            CreditAccount from = new CreditAccount(9_001, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 9_001);
            int expectedFrom = 9_001;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }

        @Test
        public void
        shouldGetTransferFromCreditToSavingIfAfterToMoreMaxBalance() {
            CreditAccount from = new CreditAccount(15_000, 500, 10);
            SavingAccount to = new SavingAccount(1_000, 100, 10_000, 5);
            Bank bank = new Bank();
            bank.transfer(from, to, 15_000);
            int expectedFrom = 15_000;
            int actualFrom = from.getBalance();
            Assertions.assertEquals(expectedFrom, actualFrom);
            int expectedTo = 1_000;
            int actualTo = to.getBalance();
            Assertions.assertEquals(expectedTo, actualTo);
        }


    }