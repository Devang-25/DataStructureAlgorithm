package multithreading;

/**
 * Created by rakeshgupta on 7/16/17.
 */
public class PrintContinuousNumber {

    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();

        Thread t1 = new Thread(testThread);
        Thread t2 = new Thread(testThread);
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();

    }
}



class TestThread extends Thread{
    private static boolean evenFlag = true;

    public synchronized void run() {

        if (evenFlag == true) {
            printEven();
        } else {
            printOdd();
        }
        Thread.yield();
    }
    public void printEven() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i+" ");
        }
        evenFlag = false;
    }
    public  void printOdd() {
        for (int i = 1; i < 10; i += 2) {
            System.out.print(i+" ");
        }
        evenFlag = true;
    }
}
