package se.multithreading;

import org.junit.Test;
import se.multithreading.domain.Bank;

import java.util.Random;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author icodeboy
 * java 核心技术卷1 第12章
 * 银行账户转账
 *  线程1，将钱从账户0转到账户1
 *  线程2，将钱从账户2转到账户3
 */
public class ThreadTest01 {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(4,10000);
        Runnable task1 = () -> {
            try {
                for(int i = 0; i < STEPS; i++){
                    double money = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, money);
                    Thread.sleep((int)(DELAY * Math.random()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                for(int i = 0; i < STEPS; i++){
                    double money = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, money);
                    Thread.sleep((int)(DELAY * Math.random()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }


    @Test
    public void t(){

    }
}


