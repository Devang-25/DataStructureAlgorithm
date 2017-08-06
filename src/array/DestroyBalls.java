package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by rakeshgupta on 8/5/17.
 */
public class DestroyBalls {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            for (int i = 0; i < t; i++) {

                int n = scanner.nextInt();
                ArrayList<Long> nums = new ArrayList();
                for (int j = 1; j <= n; j++) {
                    nums.add(scanner.nextLong());
                }

                while (true){
                    long temp = Integer.MIN_VALUE;
                    if (nums.size() > 0)
                        temp = nums.get(nums.size() - 1);
                    else
                        break;

                    if (temp == nums.size()) {
                        nums.removeAll(Collections.singleton(temp));
                    }else {
                        break;
                    }
                }

                if (nums.size() == 0){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }

            }
    }
}
