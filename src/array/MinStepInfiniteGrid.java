package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by : Rakesh Gupta on 9/7/17
 * Package : array
 */
public class MinStepInfiniteGrid {
    public static void main(String[] args) {

        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(0,1,1));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(0,1,2));

        int minStep = getMinStep(X, Y);
        System.out.println("Minimum step to reach from first to last point : " + minStep);
    }

    private static int getMinStep(ArrayList<Integer> x, ArrayList<Integer> y) {
        int size = x.size();
        int sum = 0;
        int oldX = x.get(0), oldY = y.get(0);

        for (int i = 1; i < size; i++) {
            sum += getMin(oldX, oldY, x.get(i).intValue(), y.get(i).intValue());
            oldX = x.get(i).intValue();
            oldY = y.get(i).intValue();
        }
        return sum;
    }

    private static int getMin(int oldX, int oldY, int newX, int newY) {
        int xDiff = Math.abs(oldX-newX);
        int yDiff =  Math.abs(oldY-newY);

        return  ( xDiff > yDiff) ? xDiff : yDiff;
    }

}
