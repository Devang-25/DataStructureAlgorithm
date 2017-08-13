package java8newfeatues.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 8/13/17
 * Package : java8newfeatues.lambda
 */
public class ListApplication {
    public static void main(String[] args) {
        System.out.println("Sorting list items");
        List list = Arrays.asList("rakesh", "mukesh", "priyanka", "kiran", "jaiprakash");
        Collections.sort(list, (String first,String second) ->first.length()-second.length());
        System.out.println(list);
    }
}
