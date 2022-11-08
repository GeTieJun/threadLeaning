package createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author getiejun
 * @date 2022/10/11
 */
public class Test1 {

    static class Thread1 extends Thread {
        @Override
        public void run() {
//            for (int i = 0; i < 1000; i++) {
//                System.out.println("------Thread1 extends Thread------");
//            }
            try {
                Thread.sleep(3000);
                System.out.println("------Thread1 extends Thread------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
//            for (int i = 0; i < 1000; i++) {
//                System.out.println("------thread2 implements Runnable------");
//            }
            try {
                Thread.sleep(3000);
                System.out.println("------thread2 implements Runnable------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();

        Thread thread2 = new Thread(new Thread2());

        thread1.start();

        thread1.wait();

        thread2.start();

        thread2.join(); // 主线程等待线程2执行结束后再继续执行
//        System.out.println(Thread.currentThread().getThreadGroup());
//        Thread.sleep(3000);


        System.out.println(">>>>>>>>>>main Thread<<<<<<<<<<<<");

//        thread1.notify();

    }
}
