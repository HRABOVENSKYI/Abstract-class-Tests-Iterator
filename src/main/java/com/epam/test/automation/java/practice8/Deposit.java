package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

public abstract class Deposit implements Comparable<Deposit>, Prolongable {

    public final BigDecimal amount;
    public final Integer period;

    protected Deposit(BigDecimal amount, Integer period) {
        this.amount = amount;
        this.period = period;
    }

    public abstract BigDecimal income();

    public BigDecimal totalSum() {
        return amount.add(income());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Deposit deposit) {
        return Integer.compare(this.income().compareTo(deposit.income()), 0);
    }

    @Override
    public boolean canToProlong() {
        return false;
    }
}
