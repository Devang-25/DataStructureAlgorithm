package javaexamples.regularexpression;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by : Rakesh Gupta on 8/24/17
 * Package : javaexamples.regularexpression
 */
public class SplitAlphabet {
    public static void main(String[] args) {
        String s = "%one%%two%%%three%%%%";
       String[] arr = s.split("[one,two,three]");                                           //s.split("[a-z]+");
        System.out.println(Arrays.toString(arr));
    }
}
