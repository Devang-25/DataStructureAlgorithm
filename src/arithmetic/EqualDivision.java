package arithmetic;

import java.util.Map;
import java.util.Scanner;
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

//        Map<String, Integer> map = new TreeMap<>();
//        map.put("Gamma",  3);
//        map.put("Omega", 24);
//        map.put("Alpha",  1);

//        for (Map.Entry<String, Integer> m: map.entrySet()){
//            System.out.println(m.getKey()+"="+m.getValue());
//        }

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        for (int n = 2; n < num; n++) {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
    }

        private static boolean isPrime(int n) {

            if (n > 2 && n%2 == 0)
                return false;

            int top = ((int) Math.sqrt(n))+1;
            for (int j = 3; j < top; j+=2) {
                if (n % j == 0)
                    return false;
            }
            return true;
        }

}
