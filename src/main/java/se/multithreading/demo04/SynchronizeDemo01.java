package se.multithreading.demo04;

import org.junit.Test;

/**
 * 测试 wait(), notify()方法
 * 线程A wait(), 线程B wait(), 线程C notify()
 *
 * 在JDK1.8 Hotspot环境下，按照FIFO唤醒
 */
public class SynchronizeDemo01 {
    @Test
    public void test01(){

        // 创建锁对象
        Object obj = new Object();

        // 通过Runnable 接口创建3个线程
        Thread thread_A = new Thread(new MyRunnableWait(obj));
        Thread thread_B = new Thread(new MyRunnableWait(obj));
        Thread thread_C = new Thread(new MyRunnableNotify(obj));

        // 给线程设定名字
        thread_A.setName(" 线程A ");
        thread_B.setName(" 线程B ");
        thread_C.setName(" 线程C ");

        // 运行
        thread_A.start(); // 线程A阻塞
        thread_B.start(); // 线程B阻塞
        thread_C.start(); // 线程C唤醒线程A（JDK1.8 Hotspot notify实现了公平锁，按照FIFO）
    }
}

class MyRunnableWait implements Runnable{

    // 锁对象
    Object obj;

    public MyRunnableWait(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            try {
                obj.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在运行...");
        }
    }
}

class MyRunnableNotify implements Runnable{

    // 锁对象
    Object obj;

    public MyRunnableNotify(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            try {
                //obj.notifyAll();
                obj.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在运行...");
        }
    }
}