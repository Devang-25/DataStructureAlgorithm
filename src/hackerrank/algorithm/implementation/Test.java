package hackerrank.algorithm.implementation;

/**
 * Created by rakeshgupta on 9/26/16.
 */
public class Test {
    public static void main(String[] args) {


    }

    // Subtract using plus sign only
    int negate(int num)
    {
        int minusA = 0;
        int decrementUnit = num < 0 ? 1 : -1;
        while (num != 0)
        {
            minusA += decrementUnit;
            num += decrementUnit;
        }
        return minusA;
    }

    int subtract (int a, int b)
    {
        return a + negate(b);
    }
    //



}
