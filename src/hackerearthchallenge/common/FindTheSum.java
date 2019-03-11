package hackerearthchallenge.common;

import helperutil.InputReader;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheSum {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        int n = inputReader.nextInt();
        int k = inputReader.nextInt();
        int arr[] = new int[2*n];

        for (int i = 0; i < n; i++) {
            arr[i] = inputReader.nextInt();
            arr[2*n-1-i] = arr[i];
        }
        int sum = Arrays.stream(arr).sum();
        ArrayList<Integer> arrayList = new ArrayList<>();
        addArr(arrayList,arr);
        System.out.println(arrayList);
        while (k>sum){
            addArr(arrayList, arr);
            sum += sum;
        }
        System.out.println(arrayList);
        int ans = subArraySum(arrayList.stream().mapToInt(i -> i).toArray(), k);
        System.out.println(ans+1);
    }
    static ArrayList<Integer> addArr(ArrayList<Integer> arrayList, int ar[]){
        for (int i = 0; i < ar.length; i++) {
            arrayList.add(ar[i]);
        }
        return arrayList;
    }

    static int subArraySum(int arr[], int sum) {
        int curr_sum = arr[0], start = 0, i, n=arr.length;

        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) {
                int p = i - 1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return p-start;
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }
}
