package arithmetic;

/**
 * Created by : Rakesh Gupta on 8/13/17
 * Package : arithmetic
 */
public class ExpressionCheckOfXPowerY {
    public static void main(String[] args) {
        int x = 100;

        boolean check = isRepresentable(x);
        System.out.println("Check if number " + x + " can be represented as power of something : "  + check);
    }

    private static boolean isRepresentable(int x) {

        for (int i = 2; i <= Math.sqrt(x); i++) {
            double temp =Math.log(x)/Math.log(i);
            if ( temp == (int)temp )
                return true;
        }
        return false;
    }
}
