package threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author getiejun
 * @date 2022/11/7
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
//        schedulerTest(exec);
//        schedulerAtFixedRate(exec);
        schedulerAtWithFixedDelay(exec);
//        exec.shutdown();
    }

    private static void schedulerAtWithFixedDelay(ScheduledExecutorService exec) {
        exec.scheduleAtFixedRate(new Runnable() {
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
        }, 1,5, TimeUnit.SECONDS);
    }

    private static void schedulerAtFixedRate(ScheduledExecutorService exec) {
        exec.scheduleAtFixedRate(new Runnable() {
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
        }, 1,5, TimeUnit.SECONDS);
    }

    private static void schedulerTest(ScheduledExecutorService exec) {
        for (int i = 0; i < 10; i++) {
            exec.schedule(new Runnable() {
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
            }, 1, TimeUnit.MILLISECONDS);
        }
    }

//    public void static schedulerTest(ScheduledExecutorService exec) {
//        for (int i = 0; i < 10; i++) {
//            exec.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(System.currentTimeMillis() + " ID:" + Thread.currentThread().getId());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                        e.printStackTrace();
//                    }
//                }
//            }, 1, TimeUnit.MILLISECONDS);
//        }
//    }
}
