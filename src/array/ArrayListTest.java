package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 9/4/17
 * Package : array
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        Object[] strArray = nameList.toArray();

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
    }
}
