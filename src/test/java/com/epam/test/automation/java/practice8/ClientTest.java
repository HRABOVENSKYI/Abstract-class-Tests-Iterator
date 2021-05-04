package com.epam.test.automation.java.practice8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ClientTest {

    private static final Deposit deposit1 = new SpecialDeposit(new BigDecimal("1000"), 2);
    private static final Deposit deposit2 = new SpecialDeposit(new BigDecimal("5000"), 1);
    private static final Deposit deposit3 = new SpecialDeposit(new BigDecimal("100"), 3);
    private static final Deposit deposit4 = new BaseDeposit(new BigDecimal("1000"), 4);
    private static final Deposit deposit5 = new BaseDeposit(new BigDecimal("100"), 3);
    private static final Deposit deposit6 = new LongDeposit(new BigDecimal("5000"), 8);
    private static final Deposit deposit7 = null;
    private static final Deposit deposit8 = null;
    private static final Deposit deposit9 = null;
    private static final Deposit deposit10 = null;

    private static final Client client = new Client();

    @BeforeMethod
    public void setUp() {

        client.getDeposits()[0] = deposit1;
        client.getDeposits()[1] = deposit2;
        client.getDeposits()[2] = deposit3;
        client.getDeposits()[3] = deposit4;
        client.getDeposits()[4] = deposit5;
        client.getDeposits()[5] = deposit6;

        if (client.getDeposits().length == 10) {
            client.getDeposits()[6] = null;
            client.getDeposits()[7] = null;
            client.getDeposits()[8] = null;
            client.getDeposits()[9] = null;
        }
    }

    @Test
    public void addDeposit() {

        // Test if we can add one more Deposit
        assertTrue(client.addDeposit(deposit7));

        Deposit[] expectedDeposits = {deposit1, deposit2, deposit3, deposit4, deposit5, deposit6, deposit7, deposit8,
                deposit9, deposit10
        };

        // Assert deposits was added correctly
        assertEquals(client.getDeposits(), expectedDeposits);

        client.addDeposit(deposit1);
        client.addDeposit(deposit2);
        client.addDeposit(deposit3);
        client.addDeposit(deposit4);

        // Assert we can't add more deposits
        assertFalse(client.addDeposit(deposit5));
    }

    @Test
    public void totalIncome() {

        BigDecimal totalIncome = new BigDecimal(0);

        // we use income function because we tested it before and know that it works
        for (Deposit deposit : client.getDeposits()) {
            totalIncome = totalIncome.add(deposit.income());
        }

        assertEquals(client.totalIncome(), totalIncome);
    }

    @Test
    public void testMaxIncome() {

        BigDecimal maxIncome = new BigDecimal(0);

        for (Deposit deposit : client.getDeposits()) {
            if (deposit != null && deposit.income().compareTo(maxIncome) > 0) {
                maxIncome = deposit.income();
            }
        }

        assertEquals(client.maxIncome(), maxIncome);
    }

    @Test
    public void testGetIncomeByNumber() {

        assertEquals(client.getIncomeByNumber(2), deposit3.income());
        assertEquals(client.getIncomeByNumber(0), deposit1.income());
    }

    @Test
    public void testSortDeposits() {

        client.sortDeposits();

        Deposit[] expectedDeposits = new Deposit[]
                {deposit6, deposit2, deposit4, deposit1, deposit5, deposit3};

        assertEquals(client.getDeposits(), expectedDeposits);
    }

    @Test
    public void testCountPossibleToProlongDeposit() {

        assertEquals(client.countPossibleToProlongDeposit(), 2);
    }
}

