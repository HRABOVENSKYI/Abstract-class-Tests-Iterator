package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {

    public static final double INTEREST = 0.05;

    public BaseDeposit(BigDecimal amount, Integer period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {

        BigDecimal startSum = this.amount;
        BigDecimal currentSum = startSum;
        BigDecimal percent = BigDecimal.valueOf(INTEREST);

        for (int i = 0; i < this.period; i++) {
            currentSum = currentSum.add(currentSum.multiply(percent));
        }

        return currentSum.subtract(startSum).setScale(2, RoundingMode.HALF_EVEN);
    }
}
