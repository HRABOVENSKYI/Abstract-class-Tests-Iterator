package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class LongDepositTest {

    private static final LongDeposit longDeposit1 = new LongDeposit(new BigDecimal("1000"), 7);
    private static final LongDeposit longDeposit2 = new LongDeposit(new BigDecimal("5000"), 8);
    private static final LongDeposit longDeposit3 = new LongDeposit(new BigDecimal("100"), 9);
    private static final LongDeposit longDeposit4 = new LongDeposit(new BigDecimal("1000"), 2);

    @Test
    public void testIncome() {

        Assert.assertEquals(longDeposit1.income(), new BigDecimal("150.00"));
        Assert.assertEquals(longDeposit2.income(), new BigDecimal("1612.50"));
        Assert.assertEquals(longDeposit3.income(), new BigDecimal("52.09"));
        Assert.assertEquals(longDeposit4.income(), new BigDecimal("0"));
    }

    @Test
    public void testCanToProlong() {

        Assert.assertFalse(longDeposit1.canToProlong());
        Assert.assertFalse(longDeposit2.canToProlong());
        Assert.assertFalse(longDeposit3.canToProlong());
        Assert.assertTrue(longDeposit4.canToProlong());
    }
}