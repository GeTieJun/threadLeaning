package createThread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author getiejun
 * @date 2022/11/4
 */
public class ReadWriteLockDemo {

    // 双重锁 读写都加锁
    private static Lock lock = new ReentrantLock();

    // 读写锁
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 读锁
    private static Lock readLock = readWriteLock.readLock();

    // 写锁
    private static Lock writeLock = readWriteLock.writeLock();

    private int value = 0;

    public Object handleRead(Lock lock) throws InterruptedException {
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "readLock read " + value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock) throws InterruptedException {
        try{
            lock.lock();
            value = value + 1;
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "readLock write " + value);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {

            @Override
            public void run() {
                try {
//                    demo.handleRead(readLock);
                    demo.handleRead(readLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {

            @Override
            public void run() {
                try {
//                    demo.handleWrite(writeLock);
                    demo.handleWrite(writeLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(writeRunnable).start();
        }
    }

}
