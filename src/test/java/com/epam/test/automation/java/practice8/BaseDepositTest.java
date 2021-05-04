package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BaseDepositTest {

    private static final BaseDeposit baseDeposit1 = new BaseDeposit(new BigDecimal("1000"), 4);
    private static final BaseDeposit baseDeposit2 = new BaseDeposit(new BigDecimal("5000"), 2);
    private static final BaseDeposit baseDeposit3 = new BaseDeposit(new BigDecimal("100"), 3);
    private static final BaseDeposit baseDeposit4 = new BaseDeposit(new BigDecimal("3000"), 6);

    @Test
    public void testIncome() {

        Assert.assertEquals(baseDeposit1.income(), new BigDecimal("215.51"));
        Assert.assertEquals(baseDeposit2.income(), new BigDecimal("512.50"));
        Assert.assertEquals(baseDeposit3.income(), new BigDecimal("15.76"));
        Assert.assertEquals(baseDeposit4.income(), new BigDecimal("1020.29"));
    }
}