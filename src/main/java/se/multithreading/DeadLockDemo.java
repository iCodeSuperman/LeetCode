package se.multithreading;

/**
 * 模拟死锁模型
 * 线程A持有资源2，线程B持有资源1，他们同时都想申请对方的资源，所以这两个线程就会互相等待而进入死锁状态。
 * @author icodeboy
 */
public class DeadLockDemo {
    /**
     * 系统资源1和2
     */
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        // 线程1
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + " get resource1 ...");
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " wait for resource2 ...");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " get resource2 ...");
                }
            }
        }, "线程1").start();

        // 线程2
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + " get resource2 ...");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " wait for resource1 ...");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + " get resource1 ...");
                }
            }
        }, "线程2").start();
    }

}
