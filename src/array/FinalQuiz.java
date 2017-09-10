package array;

import java.util.Scanner;

/**
 * Created by : Rakesh Gupta on 9/9/17
 * Package : array
 */
public class FinalQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {

            int X = input.nextInt();
            int Y = input.nextInt();
            int Z = input.nextInt();
            int Yb = input.nextInt();
            int Zc = input.nextInt();

            int ans = 0;
            for (int j = 0; j < X; j++) {
                int temp =  getSpecialNum(X+i, Y, Z, Yb, Zc);
                if (temp != -1)
                ans = Math.max(temp, ans);
            }

            System.out.println(ans);
        }


    }

    private static int getSpecialNum(int x, int y, int z, int yb, int zc) {

        if (x > 2*y || x > 2*z)
            return 0;

        if (2*x < (y-yb) || 2*x < (z-zc))
            return 0;

        if (2*x < y || 2*x < z)
            return 0;


        int max1 = Math.max((y-yb), (z-zc));
        if (x < max1 && max1 < 2*x )
            return (max1-x+1);

        int max2 = Math.max((y+yb), (z+zc));
        if (x < max2 && max2 < 2*x)
            return (max2-x+1);

        int max3 = Math.max((y+yb), (z-zc));
        if (x < max3 && max3 < 2*x)
            return (max3-x+1);

        int max4 = Math.max((y-yb), (z+zc));
        if (x < max4 && max4 < 2*x)
            return (max4-x+1);

        return -1;
    }
}
