package threading;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 5:7:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - threading.SequenceOfNumbersUsingMultipleThread                   *
 * Last modified - 7/5/18 12:31 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class SequenceOfNumbersUsingMultipleThread {

    public static void main(String[] args) {
        PrintingNumberThread obj = new PrintingNumberThread();
        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj);

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.start();
        thread2.start();

    }

    static class PrintingNumberThread implements Runnable{
        int i = 0;
        @Override
        public synchronized void run() {
            while(i<10)
            {

                try{
                    notify();
                    System.out.println(Thread.currentThread().getName()+" :: "+i);
                    i++;
                    wait();

                }catch(Exception e){ e.printStackTrace(); }

            }
        }
    }
}
