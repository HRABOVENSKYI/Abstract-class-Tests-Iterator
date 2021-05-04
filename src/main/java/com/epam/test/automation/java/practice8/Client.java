package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.util.*;

public class Client implements Iterable<Deposit> {

    private Deposit[] deposits;

    public Client() {
        this.deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {

        for (int i = 0; i < this.deposits.length; i++)
            if (this.deposits[i] == null) {
                this.deposits[i] = deposit;
                return true;
            }

        return false;
    }

    public BigDecimal totalIncome() {

        BigDecimal totalIncome = new BigDecimal(0);

        for (Deposit deposit : this.deposits) {
            if (deposit != null) {
                totalIncome = totalIncome.add(deposit.income());
            }
        }

        return totalIncome;
    }

    public BigDecimal maxIncome() {

        BigDecimal maxIncome = new BigDecimal(0);

        for (Deposit deposit : this.deposits) {
            if (deposit != null && deposit.income().compareTo(maxIncome) > 0) {
                maxIncome = deposit.income();
            }
        }

        return maxIncome;
    }

    public BigDecimal getIncomeByNumber(int number) {

        if (this.deposits.length < number + 1 || this.deposits[number] == null)
            return new BigDecimal(0);

        return this.deposits[number].income();
    }

    public Deposit[] getDeposits() {
        return deposits;
    }


    @Override
    public Iterator<Deposit> iterator() {
        return new ClientIterator();
    }

    private class ClientIterator implements Iterator<Deposit> {

        private int position = 0;

        public boolean hasNext() {
            return position < deposits.length;
        }

        public Deposit next() {
            if (this.hasNext())
                return deposits[position++];
            else
                throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public void sortDeposits() {

        removeNullElementsFromArray();

        Arrays.sort(deposits, Collections.reverseOrder(Comparator.comparing(Deposit::totalSum)));
    }

    private void removeNullElementsFromArray() {

        deposits = Arrays.stream(deposits).filter(Objects::nonNull).toArray(Deposit[]::new);
    }

    public int countPossibleToProlongDeposit() {

        int count = 0;

        for (Deposit deposit : this.deposits) {
            if (deposit != null && deposit.canToProlong()) {
                count++;
            }
        }

        return count;
    }
}
