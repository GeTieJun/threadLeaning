package createThread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author getiejun
 * @date 2022/11/7
 */
public class CountDownLatchDemo implements Runnable {

    static final CountDownLatch countDownLatch = new CountDownLatch(10);
    static final CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();

    @Override
    public void run() {
        try{
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(Thread.currentThread().getName() + " ------> check complete");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " ------> thread execute");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(countDownLatchDemo);
        }

        // 要求主线程等待所有检查任务全部完成，主线程才能继续执行
        countDownLatch.await();

        System.out.println("fire!");

        exec.shutdown();
    }
}
