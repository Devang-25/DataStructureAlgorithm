package hackerearthchallenge.fullcontact;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CircularPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long a = scanner.nextLong();
        
        StringBuffer out = new StringBuffer();
        out.append(a);
        Set<Long> nums = new HashSet<>();
        nums.add(a);

        long b = a;
        while (true){
            if (b < (2^n)){



            }else {
                break;
            }
        }
    }
}
