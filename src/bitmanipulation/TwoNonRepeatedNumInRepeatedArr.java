package bitmanipulation;

public class TwoNonRepeatedNumInRepeatedArr {
    public static void main(String[] args) {
        printTwoOdd(new int[] {1, 3, 5, 4, 3, 5, 6, 6}, 8);
    }

    private static void printTwoOdd(int arr[], int size) {
        int xorOfTwoNum = arr[0];

        int x = 0, y = 0;

        for (int i = 1; i < size; i++) {
            xorOfTwoNum = xorOfTwoNum ^ arr[i];
        }
        int setBitNo = xorOfTwoNum & ~(xorOfTwoNum - 1);

        for (int i = 0; i < size; i++) {

            if ((arr[i] & setBitNo) > 0) {
                x = x ^ arr[i];
            } else {
                y = y ^ arr[i];
            }
        }
        System.out.println("The two ODD elements are " + x + " & " + y);
    }
}
