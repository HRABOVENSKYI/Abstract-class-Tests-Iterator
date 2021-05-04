package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable {

    private static final double BASIC_INTEREST = 0.01;

    public SpecialDeposit(BigDecimal amount, Integer period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {

        BigDecimal startSum = this.amount;
        BigDecimal currentSumAndIncome = startSum;

        for (int i = 0; i < this.period; i++) {
            BigDecimal percent = BigDecimal.valueOf(BASIC_INTEREST * (i + 1));
            currentSumAndIncome = currentSumAndIncome.add(currentSumAndIncome.multiply(percent));
        }

        return currentSumAndIncome.subtract(startSum).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean canToProlong() {
        return amount.compareTo(new BigDecimal(1000)) > 0;
    }
}
