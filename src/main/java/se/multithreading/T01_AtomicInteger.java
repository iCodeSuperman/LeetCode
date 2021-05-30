package se.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author D-L
 * @Classname T01_AtomicInteger
 * @Version 1.0
 * @Description 使用AtomicInteger类代替synchronized
 * @Date 2020/7/22
 */
public class T01_AtomicInteger {
    int count = 0;
    //AtomicInteger count = new AtomicInteger(0);

    public synchronized void m(){
        for (int i = 0; i < 1000; i++) {
            count++;
            //count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T01_AtomicInteger t = new T01_AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m ,"Thread" + i));
        }
        threads.forEach(o -> o.start());
        // threads.forEach(o ->{
        //     try {
        //         o.join();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // });
    /* for (int i = 0; i < 10; i++) {
      new Thread(t::m ,"Thread"+i).start();
    }
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
        TimeUnit.SECONDS.sleep(3);
        System.out.println(t.count);
    }
}