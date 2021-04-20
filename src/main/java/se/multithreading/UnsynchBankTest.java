package se.multithreading;

import se.multithreading.domain.Bank;

/**
 * @author icodeboy
 * java 核心技术卷1 第12章
 * 不断从一个给定账户取钱，选择一个随机账户打入随机金额
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;
    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while(true){
                        int toAccount = (int)(bank.getSize() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            };

            new Thread(r).start();
        }
    }
}
