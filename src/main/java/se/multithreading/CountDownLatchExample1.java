package se.multithreading;

import java.util.concurrent.*;

/**
 * @author icodeboy
 */
public class CountDownLatchExample1 {
    /**
     * 处理文件的数量
     */
    private final static int count = 6;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 1L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());

        final CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            final int threadNum = i;
            threadPool.execute( () -> {
                try{
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread()+" 文件"+threadNum+"读取成功...");
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("main() finish");
    }

}
