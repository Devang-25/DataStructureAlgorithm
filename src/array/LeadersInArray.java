package array;

import java.util.Scanner;
import java.util.Stack;

public class LeadersInArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {

            int size = s.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = s.nextInt();
            }
            printLeadersInArray(arr);
        }
    }

    private static void printLeadersInArray(int[] arr) {
        Stack<Integer> out = new Stack<>();
        int rightMax = arr[arr.length - 1];
        out.add(rightMax);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= rightMax) {
                rightMax = arr[i];
                out.add(rightMax);
            }
        }
        StringBuffer sb = new StringBuffer(arr.length);
        while (!out.isEmpty()) {
            sb.append(out.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}
