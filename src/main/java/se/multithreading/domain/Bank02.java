package se.multithreading.domain;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author icodeboy
 *  进入临界区之前，用了ReentrantLock() 加锁和解锁
 *  加了对余额的pv操作，当账户里面没有足够余额时候，应该等待，直到另外一个线程向账户里面增加了金额
 */
public class Bank02 {
    /**
     * 账户列表
     * 临界区锁
     * 条件对象
     */
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank02(){
        this(4, 10000);
    }

    public Bank02(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        // 默认非公平，公平效率太低了
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();

    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount){
                sufficientFunds.await();
            }
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.printf("%s %10.2f from %d to %d Total Balance: %10.2f %n",
                    Thread.currentThread(), amount, from, to, getTotalBalance());
            sufficientFunds.signalAll();
        }finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance(){
        bankLock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int getSize(){
        return accounts.length;
    }
}
