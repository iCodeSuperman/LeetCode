package se.multithreading.demo04;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 * 使用Object.wait()/notify() 实现同步队列
 */
public class SynchronizeDemo03 {
    private int dequeSize = 10;
    private Deque<Integer> deque = new ArrayDeque<>(dequeSize);

    public static void main(String[] args) {
        SynchronizeDemo03 s3 = new SynchronizeDemo03();
        s3.t();
    }

    @Test
    public void t(){

        Thread t1 = new Thread(new Consumer());
        Thread t2 = new Thread(new Producer());

        t1.setName(" 消费者 ");
        t2.setName(" 生产者 ");

        t2.start();
        t1.start();
    }

    /**
     * 消费者
     */
    private class Consumer implements Runnable{

        @Override
        public void run() {
            while(true) {
                synchronized (deque){
                    while(deque.size() == 0){
                        try {
                            System.out.println("队列空了，等待生产者补充资料...");
                            deque.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            deque.notify();
                        }
                    }
                    deque.removeFirst();
                    //deque.poll();
                    // 注意取走以后一定要唤醒，因为生产者可能因为队列满了而阻塞
                    deque.notify();
                    System.out.println("从队列中取走一个元素，队列还有"+deque.size()+"个元素...");
                }
            }
        }
    }

    /**
     * 生产者
     */
    private class Producer implements Runnable{

        @Override
        public void run() {
            while(true) {
                synchronized (deque){
                    // 当队列满了，就阻塞
                    while(deque.size() == dequeSize){
                        try {
                            System.out.println("队列满了，等待消费者取走...");
                            deque.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            deque.notify();
                        }
                    }

                    deque.addLast(1);
                    //deque.offer(1);
                    deque.notify();
                    System.out.println("生产者生产了一个元素，队列中还有"+deque.size()+"个元素...");

                }
            }
        }
    }

}


