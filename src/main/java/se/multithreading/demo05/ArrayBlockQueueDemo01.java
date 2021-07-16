package se.multithreading.demo05;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author icodeboy
 * 实现生产者消费者
 */
public class ArrayBlockQueueDemo01 {
    private int queueSize = 5;
    private BlockingQueue<Integer> abq = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ArrayBlockQueueDemo01 abq = new ArrayBlockQueueDemo01();
        abq.t();
    }


    public void t(){
        Thread t1 = new Thread(new Consumer());
        Thread t2 = new Thread(new Producer());
        t1.setName(" 消费者 ");
        t2.setName(" 生产者 ");

        t1.start();
        t2.start();
    }


    private class Consumer implements Runnable{

        @Override
        public void run() {
            consume();
        }

        public void consume(){
            while (true){
                try {
                    abq.take();
                    System.out.println("取走元素，还剩下"+abq.size()+"个元素；");
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    private class Producer implements Runnable{

        @Override
        public void run() {
            produce();
        }

        public void produce(){
            while (true){
                try {
                    abq.put(1);
                    System.out.println("添加元素，空间剩余"+(queueSize - abq.size()));
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void t2(){
        List<Integer> cl = new CopyOnWriteArrayList<>();
    }

}
