package arithmetic;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by : Rakesh Gupta on 8/19/17
 * Package : arithmetic
 */
public class ConnectKDevice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long arrX[] = new long[N];
        long arrY[] = new long[N];

        for (int i = 0; i < N; i++) {
            arrX[i] = scanner.nextLong();
        }
        for (int i = 0; i < N; i++) {
            arrY[i] = scanner.nextLong();
        }

        double distance[] = new double[N];

        for (int i = 0; i <N; i++) {
            long d = (arrX[i]*arrX[i]) + (arrY[i]*arrY[i]);
            distance[i] = Math.sqrt(d);
        }

        Arrays.sort(distance);

        double ans =  distance[K-1];
        System.out.println(((int) Math.ceil(ans)));
    }
}
