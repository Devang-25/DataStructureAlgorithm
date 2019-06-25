package multithreading;

/**
 * Created by rakeshgupta on 7/16/17.
 */
public class MyThread {

    public static void main(String[] args) {
        Runnable r = new Runnable1();
        Thread t = new Thread(r);
        Runnable r2 = new Runnable2();
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();
    }

    static class Runnable2 implements Runnable {
        public void run() {
            for (int i = 0; i < 11; i += 2) {
                System.out.println(i);
            }
        }
    }

    static class Runnable1 implements Runnable {
        public void run() {
            for (int i = 1; i <= 11; i += 2) {
                System.out.println(i);
            }
        }
    }
}
