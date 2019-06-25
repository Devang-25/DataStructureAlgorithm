package multithreading;

/**
 * Created by rakeshgupta on 7/16/17.
 */
public class EvenOddPrinting {

    public static void main(String[] args) throws InterruptedException {
        NewThread newThread = new NewThread();
        Thread thread = new Thread(newThread);
        thread.start();
        for (int i=1; i <10; i=i+2){
            System.out.print("T1:" + i + "  ");
            Thread.sleep(2000);
        }
    }

   static class NewThread implements Runnable{
        @Override
        public void run() {
            for (int j=2;j<=10;j=j+2){
                System.out.print("T2:" + j + "  ");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

