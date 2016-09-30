package hackerrank.algorithm.logicalproblem;

/**
 * Created by rakeshgupta on 9/26/16.
 */
import java.util.ArrayList;
import java.util.List;


public class PascalTriangal {

    public static void main (String args[])
    {
        int numRows = 10;
        int maxNumLen = 6;
        int maxNumLenFactor = maxNumLen/2;

        List <Integer> nums = new ArrayList<Integer> ();
        nums.add(1);

        for (int i=1; i<=numRows; i++)
        {
            System.out.println("\n");
            for (int j=2;j<maxNumLenFactor*(numRows-i); j++)
                System.out.print(" ");

            nums.add(0, 1);
            for (int j=1; j<nums.size()-1; j++)
            {
                int curr = nums.get(j);
                int next = nums.get(j+1);
                nums.set(j, curr+next);
                System.out.print(String.format ("%8d", curr) + " ");
            }
            System.out.print(String.format ("%8d",nums.get(nums.size()-1)) + " ");
        }
    }
}
