package se.multithreading;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author icodeboy
 */
public class AtomicIntegerTest {

    private AtomicInteger count = new AtomicInteger();

    public void increment(){
        System.out.println(count.get());
    }

    public int getCount(){
        return count.get();
    }

    @Test
    public void t(){
        System.out.println(count.getAndSet(10));
        System.out.println(count.getAndIncrement());
    }

}
