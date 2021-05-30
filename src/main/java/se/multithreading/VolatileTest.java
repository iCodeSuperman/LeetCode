package se.multithreading;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class VolatileTest{
    private int count = 0;
    public synchronized void m(){
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        VolatileTest vt = new VolatileTest();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(vt::m);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        System.out.println(vt.count);
    }
}
