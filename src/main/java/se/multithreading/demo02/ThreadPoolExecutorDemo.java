package se.multithreading.demo02;

import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author icodeboy
 */
public class ThreadPoolExecutorDemo {
    /**
     * 能同时运行的最小线程数量
     */
    private static final int CORE_POOL_SIZE = 5;

    /**
     * 当任务队列放满了，此时能同时运行的最大线程数量
     */
    private static final int MAX_POOL_SIZE = 10;

    /**
     * 任务队列，用来存放等待执行任务的队列
     */
    private static final int QUEUE_CAPACITY = 100;

    /**
     * 当线程数量多于核心线程数量时，多于线程可以存活的最大时间
     */
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new NamingThreadFactory(threadFactory, "徐彦祖"),
                new ThreadPoolExecutor.AbortPolicy()
                );

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "; date:" + Instant.now());
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");

    }

}

/**
 * 线程工厂，它设置线程名称，有利于定位问题
 */
class NamingThreadFactory implements ThreadFactory{

    private final AtomicInteger threadNum = new AtomicInteger();
    private final ThreadFactory delegate;
    private final String name;

    /**
     * 创建一个带名字的线程池生产工厂
     * @param
     * @return
     */
    public NamingThreadFactory(ThreadFactory delegate, String name){
        this.delegate = delegate;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = delegate.newThread(r);
        t.setName((name + "[#" + threadNum.incrementAndGet() + "]"));
        return t;
    }
}
