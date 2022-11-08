package createThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author getiejun
 * @date 2022/11/4
 * 重入锁
 */
public class ReEntrantLockTest {

    public static class ReEntrantLock implements Runnable {

        public static ReentrantLock instance = new ReentrantLock();

        public static Long i = 0L;

        @Override
        public void run() {
            System.out.println(">>>>" + Thread.currentThread().getName());
            for (int j = 0; j < 100000; j++) {
                instance.lock();
                try{
                    i++;
                } finally {
                    instance.unlock();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReEntrantLock thread = new ReEntrantLock();
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(ReEntrantLock.i);
    }
}
