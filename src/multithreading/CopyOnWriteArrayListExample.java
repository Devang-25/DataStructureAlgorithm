package multithreading;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        new WriteThread("Writer", list).start();
        new ReadThread("Reader", list).start();
    }

    static class WriteThread extends Thread {
        private List<Integer> list;

        public WriteThread(String name, List<Integer> list) {
            this.list = list;
            super.setName(name);
        }

        public void run() {
            int count = 6;

            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                list.add(count++);
                System.out.println(super.getName() + " done");
            }
        }
    }

    static class ReadThread extends Thread {
        private List<Integer> list;

        public ReadThread(String name, List<Integer> list) {
            this.list = list;
            super.setName(name);
        }

        public void run() {

            while (true) {
                String output = "\n" + super.getName() + ":";
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    output += " " + next;

                    // fake processing time
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println(output);
            }
        }
    }
}
