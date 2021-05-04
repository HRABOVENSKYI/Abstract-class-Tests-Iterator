package com.epam.test.automation.java.practice8;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit implements Prolongable {

    private static final double INTEREST = 0.15;

    public LongDeposit(BigDecimal amount, Integer period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {

        BigDecimal startSum = this.amount;
        BigDecimal currentSum = startSum;
        BigDecimal percent = BigDecimal.valueOf(INTEREST);

        if (period < 7) {
            return new BigDecimal(0);
        }

        for (int i = 0; i < this.period - 6; i++) {
            currentSum = currentSum.add(currentSum.multiply(percent));
        }

        return currentSum.subtract(startSum).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean canToProlong() {
        return period < 36;
    }
}
