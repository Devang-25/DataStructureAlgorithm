package javaexamples;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class ScannerTest {
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("DBS");
            }
        };

        Thread t = new Thread(r) {
            @Override
            public void run() {
                System.out.println("ASIA");
            }
        };

        t.start();

    }
    public static void tet(byte... a){
        System.out.println("long");
    }
    public static void tet(int a, int b, int c){
        System.out.println("int");
    }

}
