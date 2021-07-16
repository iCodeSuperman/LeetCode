package se.multithreading.demo04;

import org.junit.Test;

public class SynchronizeDemo02 {
    @Test
    public void t(){
        Object obj = new Object();
        Thread t1 = new Thread(new MyRunnable1(obj));
        Thread t2 = new Thread(new MyRunnable2(obj));

        t1.setName(" 线程A ");
        t2.setName(" 线程B ");

        t1.start();
        t2.start();
    }
}

class MyRunnable1 implements Runnable{
    // 锁对象
    private Object obj;

    public MyRunnable1(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            try {
                obj.wait();
                System.out.println(Thread.currentThread().getName() + " 获得了锁。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class MyRunnable2 implements Runnable{
    // 锁对象
    private Object obj;

    public MyRunnable2(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            try {
                obj.notifyAll();
                System.out.println(Thread.currentThread().getName() + " 唤醒了别人。");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + " 释放了obj的锁");
    }
}