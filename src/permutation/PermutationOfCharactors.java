package permutation;

/**
 * Created by rakeshgupta on 7/15/17.
 */
public class PermutationOfCharactors {

    public static void main(String[] args) {
        char[] input = { '1', '0'};
        permute(Integer.toBinaryString(20).toCharArray(), 0);
    }

    public static void permute(char[] input2, int startindex) {

        if (input2.length == startindex) {
            displayArray(input2);
            return;
        }
        for (int i = startindex; i < input2.length; i++) {
                char[] input = input2.clone();
                char temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
                permute(input, startindex + 1);
            }

    }


    private static void displayArray(char[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

}
