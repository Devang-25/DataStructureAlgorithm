package array;

public class MaximumOccuringElementInRange {

    private static final int MAX = 1000000;

    public static void main(String[] args) {
        int[] L = {1, 4, 9, 13, 21};
        int[] R = {15, 8, 12, 20, 30};
        System.out.println(maximumOccuredElement(L, R));
    }

    private static int maximumOccuredElement(int[] L, int[] R) {

        int[] arr = new int[MAX];
        int n = L.length;

        // Adding +1 at Li index and
        // substracting 1 at Ri index.
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
        }

        // Finding prefix sum and index
        // having maximum prefix sum.
        int maxSum = arr[0];
        int idx = 0;
        for (int i = 1; i < MAX; i++) {
            arr[i] += arr[i - 1];
            if (maxSum < arr[i]) {
                maxSum = arr[i];
                idx = i;
            }
        }

        return idx;
    }
}
