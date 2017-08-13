package java8newfeatues.intstream;

import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * Created by : Rakesh Gupta on 8/13/17
 * Package : java8newfeatues.intstream
 */
public class StreamExample {
    public static void main(String[] args) {
        System.out.print("Example of IntStream.of(int) method :  ");
        IntStream intStream = IntStream.of(5, 4, 6, 8);
        printIntStream(intStream);

        System.out.print("\nExample of IntSream.range(start,end) method :  ");
        IntStream intStream1 = IntStream.range(2,9);
        printIntStream(intStream1);


        System.out.print("\nExample of IntSream.rangeClosed(start,end) method :  ");
        IntStream intStream2 = IntStream.rangeClosed(2,9);
        printIntStream(intStream2);



    }

    public static void printIntStream(IntStream intStream){
        Iterator iterator = intStream.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+ " ");
        }
    }
}
