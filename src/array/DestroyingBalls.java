package array;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 8/5/17.
 */
public class DestroyingBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t  = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                stringBuffer.append(scanner.nextInt());
            }
            int strSize = stringBuffer.length();
            String str = stringBuffer.toString();
            System.out.println(strSize);
            System.out.println(str);
            System.out.println(Integer.parseInt((str.charAt(str.length()-1))+""));


            while (Integer.parseInt((str.charAt(str.length()-1))+"") == (str.length()-1)) {

                str = str.replace(str.charAt(str.length()-1)+"", "");
                System.out.println("Inside");
            }

            System.out.println(str);
            if (str.length() == 0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
