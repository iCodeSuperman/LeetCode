package se.multithreading.domain;

import java.util.Arrays;

/**
 * @author icodeboy
 *
 */
public class Bank {
    private final double[] accounts;

    public Bank(){
        this(4, 10000);
    }

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount){
        if(accounts[from] < amount) {
            return;
        }
        accounts[from] -= amount;
        accounts[to] += amount;

        System.out.printf("%s %10.2f from %d to %d Total Balance: %10.2f %n",
                Thread.currentThread(), amount, from, to, getTotalBalance());
    }

    public double getTotalBalance(){
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int getSize(){
        return accounts.length;
    }
}
