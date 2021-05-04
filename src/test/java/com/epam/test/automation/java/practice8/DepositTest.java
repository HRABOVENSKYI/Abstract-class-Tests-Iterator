package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Modifier;
import java.math.BigDecimal;

public class DepositTest {

    private static final Deposit deposit1 = new SpecialDeposit(new BigDecimal("1000"), 2);
    private static final Deposit deposit2 = new SpecialDeposit(new BigDecimal("5000"), 1);
    private static final Deposit deposit3 = new SpecialDeposit(new BigDecimal("100"), 3);
    private static final Deposit deposit4 = new BaseDeposit(new BigDecimal("1000"), 4);
    private static final Deposit deposit5 = new BaseDeposit(new BigDecimal("100"), 3);
    private static final Deposit deposit51 = new BaseDeposit(new BigDecimal("100"), 3);
    private static final Deposit deposit6 = new LongDeposit(new BigDecimal("5000"), 8);

    @Test
    public void testIfClassIsAbstract() {

        Class<Deposit> clazz = Deposit.class;

        Assert.assertTrue(Modifier.isAbstract(clazz.getModifiers()));
    }

    @Test
    public void testCompareTo() {

        Assert.assertEquals(deposit1.compareTo(deposit2), -deposit2.compareTo(deposit1));
        Assert.assertEquals(deposit1.compareTo(deposit6), -deposit6.compareTo(deposit1));
        Assert.assertEquals(deposit6.compareTo(deposit5), -deposit5.compareTo(deposit6));

        Assert.assertEquals(deposit1.compareTo(deposit2), -1);
        Assert.assertEquals(deposit1.compareTo(deposit3), 1);
        Assert.assertEquals(deposit5.compareTo(deposit51), 0);
    }

    @Test
    public void testCanToProlong() {

        Assert.assertFalse(deposit4.canToProlong());
        Assert.assertFalse(deposit5.canToProlong());
        Assert.assertFalse(deposit51.canToProlong());
    }
}