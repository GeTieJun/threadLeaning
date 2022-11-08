package createThread;

/**
 * @author getiejun
 * @date 2022/11/4
 */
public class SimpleWN {

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        thread1.start();
        Thread.sleep(1000);
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(">>>Thread1 start....");
                try {
                    System.out.println(">>>Thread1 wait....");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(">>>Thread1 end....");
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(">>>Thread2 start....");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                object.notify();
            }
            System.out.println(">>>Thread2 end....");
        }
    }

}
