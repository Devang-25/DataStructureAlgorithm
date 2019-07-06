package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Item> blockingDeque = new ArrayBlockingQueue<>(20);

        //Producer
        final Runnable producer = () -> {
            while (true) {
                try {
                    blockingDeque.put(new Item());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        //new Thread(producer).start();

        //Consumer
        final Runnable consumer = () -> {
            while (true) {
                try {
                    Item item = blockingDeque.take();
                    System.out.println(item.getNum());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();

        Thread.sleep(2000);
    }

    static class Item {
        static  int num;

        public Item() {
            this.num ++;
        }

        public int getNum() {
            return num;
        }
    }

}
