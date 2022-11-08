package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author getiejun
 * @date 2022/11/7
 */
public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis() + " ID:" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            });
        }
        exec.shutdown();
    }
}
