package arithmetic;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by : Rakesh Gupta on 9/4/17
 * Package : arithmetic
 */
public class EqualDivision {
    public static void main(String[] args) {
//        java.util.Scanner scanner = new java.util.Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        System.out.println(b/a);

        Map<String, Integer> map = new TreeMap<>();
        map.put("Gamma",  3);
        map.put("Omega", 24);
        map.put("Alpha",  1);

        for (Map.Entry<String, Integer> m: map.entrySet()){
            System.out.println(m.getKey()+"="+m.getValue());
        }

    }
}
