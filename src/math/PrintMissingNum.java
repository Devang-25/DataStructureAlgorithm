package math;

import helperutil.InputReader;

import java.util.Arrays;
import java.util.BitSet;

public class PrintMissingNum {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        int actSize = inputReader.nextInt();
        int arrSize = inputReader.nextInt();
        int arr[] = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = inputReader.nextInt();
        }
        printMissingNumber(arr, actSize);

        int missing = getMissingNumber(arr, actSize);
        System.out.printf("\nMissing number in array %s, with total number %d is %d %n", Arrays.toString(arr), actSize, missing);
    }

    /**
     * This will work for more than one missing number.
     *
     * @param numbers
     * @param count
     */
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
        System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.print(++lastMissingIndex + "  ");
        }
    }

    /**
     *  Only if there is one missing num in array.
     * @param numbers
     * @param totalCount
     * @return
     */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }


}
