package createThread;

/**
 * @author getiejun
 * @date 2022/11/4
 */
public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(3000);
        System.out.println(">>>main thread stop");
    }

    public static class DaemonThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println(">>>daemon thread alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }
    }
}
