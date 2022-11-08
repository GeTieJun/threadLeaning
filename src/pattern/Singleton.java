package pattern;

/**
 * @author getiejun
 * @date 2022/11/7
 */
public class Singleton {

    private Singleton() {
        System.out.println("new Singleton()");
    }

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        Singleton.getInstance();
    }
}
