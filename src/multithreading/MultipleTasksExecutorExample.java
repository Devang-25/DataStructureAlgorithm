package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleTasksExecutorExample {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));

        pool.shutdown();
    }

    static class CountDownClock extends Thread {
        private String clockName;

        public CountDownClock(String clockName) {
            this.clockName = clockName;
        }

        public void run() {
            String threadName = Thread.currentThread().getName();

            for (int i = 5; i >= 0; i--) {

                System.out.printf("%s -> %s: %d\n", threadName, clockName, i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
