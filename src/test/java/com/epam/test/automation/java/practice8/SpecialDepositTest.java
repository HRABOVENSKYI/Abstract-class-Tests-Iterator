package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class SpecialDepositTest {

    private static final SpecialDeposit specialDeposit1 = new SpecialDeposit(new BigDecimal("1000"), 2);
    private static final SpecialDeposit specialDeposit2 = new SpecialDeposit(new BigDecimal("5000"), 1);
    private static final SpecialDeposit specialDeposit3 = new SpecialDeposit(new BigDecimal("100"), 3);

    @Test
    public void testIncome() {

        Assert.assertEquals(specialDeposit1.income(), new BigDecimal("30.20"));
        Assert.assertEquals(specialDeposit2.income(), new BigDecimal("50.00"));
        Assert.assertEquals(specialDeposit3.income(), new BigDecimal("6.11"));
    }

    @Test
    public void testCanToProlong() {

        Assert.assertFalse(specialDeposit1.canToProlong());
        Assert.assertTrue(specialDeposit2.canToProlong());
        Assert.assertFalse(specialDeposit3.canToProlong());
    }
}