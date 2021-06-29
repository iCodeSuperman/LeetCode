package se.multithreading.demo03;

import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 await(), signal()方法
 * 线程A wait(), 线程B wait(), 线程C signal()
 *
 * 在JDK1.8 Hotspot环境下，按照FIFO唤醒
 */
public class ReentrantLockDemo01 {

    /**
     * 这里A,B 用了同一个Condition，所以C的唤醒，按照FIFO
     */
    @Test
    public void test01(){
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread thread_A = new Thread(new MyRunnableAwait(lock, condition));
        Thread thread_B = new Thread(new MyRunnableAwait(lock, condition));
        Thread thread_C = new Thread(new MyRunnableSignal(lock, condition));

        thread_A.setName(" 线程A ");
        thread_B.setName(" 线程B ");
        thread_C.setName(" 线程C ");

        thread_A.start(); // 线程A阻塞
        thread_B.start(); // 线程B阻塞
        thread_C.start(); // 线程C唤醒

    }

    /**
     * 这里A,B 用了不同的Condition，所以C可以自定义唤醒
     */
    @Test
    public void test02(){
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Thread thread_A = new Thread(new MyRunnableAwait(lock, condition));
        Thread thread_B = new Thread(new MyRunnableAwait(lock, condition2));
        Thread thread_C = new Thread(new MyRunnableSignal(lock, condition2));

        thread_A.setName(" 线程A ");
        thread_B.setName(" 线程B ");
        thread_C.setName(" 线程C ");

        thread_A.start(); // 线程A阻塞
        thread_B.start(); // 线程B阻塞
        thread_C.start(); // 线程C唤醒
    }
}


class MyRunnableAwait implements Runnable{

    ReentrantLock lock;
    Condition condition;

    public MyRunnableAwait(ReentrantLock lock, Condition condition){
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();
        try {
            condition.await();
            System.out.println(Thread.currentThread().getName() + "运行了...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class MyRunnableSignal implements Runnable{

    ReentrantLock lock;
    Condition condition;

    public MyRunnableSignal(ReentrantLock lock, Condition condition){
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();
        try {
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "运行了...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}