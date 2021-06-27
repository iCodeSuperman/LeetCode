package se.multithreading.demo01;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 当corePoolSize 和 maximumPoolSize 都空闲时，
 * 在keeplive内，不断扔进任务，这个情况下，一直活跃的线程有几个？
 */
public class ThreadTest {
    @Test
    public void test() throws InterruptedException {

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                2,
                3,
                30,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2),
                new DefaultThreadFactory(Executors.defaultThreadFactory(), "test"),
                new ThreadPoolExecutor.DiscardPolicy());

        //每隔两秒打印线程池的信息
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("=====================================thread-pool-info:" + new Date() + "=====================================");
            System.out.println("CorePoolSize:" + executorService.getCorePoolSize());
            System.out.println("PoolSize:" + executorService.getPoolSize());
            System.out.println("ActiveCount:" + executorService.getActiveCount());
            System.out.println("KeepAliveTime:" + executorService.getKeepAliveTime(TimeUnit.SECONDS));
            System.out.println("QueueSize:" + executorService.getQueue().size());
        }, 0, 2, TimeUnit.SECONDS);

        try {
            //同时提交5个任务,模拟达到最大线程数
            for (int i = 0; i < 5; i++) {
                executorService.execute(new Task());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //休眠10秒，打印日志，观察线程池状态
        Thread.sleep(10000);

        //每隔3秒提交一个任务
        while (true) {
            Thread.sleep(3000);
            executorService.submit(new Task());
        }
    }

    static class Task implements Runnable {
        @Override
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "-执行任务");
        }
    }
}


/**
 * 线程工厂，它设置线程名称，有利于定位问题
 */
class DefaultThreadFactory implements ThreadFactory{

    private final AtomicInteger threadNum = new AtomicInteger();
    private final ThreadFactory delegate;
    private final String name;

    /**
     * 创建一个带名字的线程池生产工厂
     * @param
     * @return
     */
    public DefaultThreadFactory(ThreadFactory delegate, String name){
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
