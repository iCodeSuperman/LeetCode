package se.multithreading.domain;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank03 {
    /**
     * 账户列表
     * 使用synchronize替代ReentrantLock()
     */
    private final double[] accounts;

    public Bank03(){
        this(4, 10000);
    }

    public Bank03(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            // p 操作
            wait();
        }
        accounts[from] -= amount;
        accounts[to] += amount;
        System.out.printf("%s %10.2f from %d to %d Total Balance: %10.2f %n",
                Thread.currentThread(), amount, from, to, getTotalBalance());
        notifyAll();

    }

    public synchronized double getTotalBalance(){
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
