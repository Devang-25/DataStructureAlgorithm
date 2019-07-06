package bitmanipulation;

public class TwoNonRepeatedNumInRepeatedArr {
    public static void main(String[] args) {
        printTwoOdd(new int[]{1, 3, 5, 4, 3, 5, 6, 6}, 8);
    }

    private static void printTwoOdd(int arr[], int size) {
        int xorOfTwoNum = arr[0];

        int setBitNo;
        int i;
        int x = 0, y = 0;

        for (i = 1; i < size; i++) {
            xorOfTwoNum = xorOfTwoNum ^ arr[i];
        }
        setBitNo = xorOfTwoNum & ~(xorOfTwoNum - 1);

        for (i = 0; i < size; i++) {
            /* XOR of first set is finally going
            to hold one odd occurring number x */
            if ((arr[i] & setBitNo) > 0) {
                x = x ^ arr[i];
            } else {
                y = y ^ arr[i];
            }
        }

        System.out.println("The two ODD elements are " + x + " & " + y);
    }
}
