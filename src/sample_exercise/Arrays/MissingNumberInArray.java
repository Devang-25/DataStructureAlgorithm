package sample_exercise.Arrays;

import java.util.stream.IntStream;

/**
 * Created by rakeshgupta on 2/14/17.
 */
public class MissingNumberInArray {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <101 ; i++) {
            sum += i;
        }
        System.out.println(sum);
        int[] a = IntStream.range(1, 100).toArray();

        for (int b : a){
            System.out.println(b);
        }



    }
}
