package se.multithreading.demo03;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author icodeboy
 */
public class PCbyCondition {
    private int dequeSize = 5;
    private Deque<Integer> deque = new ArrayDeque<>(dequeSize);
    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public static void main(String[] args) {
        PCbyCondition pc = new PCbyCondition();
        pc.t();
    }

    public void t(){
        Thread t1 = new Thread(new Consumer());
        Thread t2 = new Thread(new Producer());

        t1.setName(" 消费者 ");
        t2.setName(" 生产者 ");

        t1.start();
        t2.start();
    }

    /**
     * 消费者
     */
    private class Consumer implements Runnable{

        @Override
        public void run() {
            while(true) {
                lock.lock();
                try {
                    while(deque.size() == 0){
                        try {
                            System.out.println("队列空了，等待生产者补充资料...");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            deque.notify();
                        }
                    }
                    deque.removeFirst();
                    // 注意取走以后一定要唤醒，因为生产者可能因为队列满了而阻塞
                    notFull.signal();
                    System.out.println("从队列中取走一个元素，队列还有"+deque.size()+"个元素...");
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
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
                lock.lock();
                try {
                    while(deque.size() == dequeSize){
                        try {
                            System.out.println("队列满了，等待消费者消费...");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            deque.notify();
                        }
                    }
                    deque.addLast(1);
                    // 注意取走以后一定要唤醒，因为生产者可能因为队列满了而阻塞
                    notEmpty.signal();
                    System.out.println("向队列中添加一个元素，队列还有"+deque.size()+"个元素...");
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
