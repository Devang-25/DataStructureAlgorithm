package bitmanipulation;

/**
 * Created by : Rakesh Gupta on 9/7/17
 * Package : bitmanipulation
 */
public class OnceAppearanceInArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,5,4,3,2,1,8,8,9,9};

        int onceAppeared = findRequiredNum(arr, 2);
        System.out.println("Find the element that appeared once in array : " + onceAppeared);
    }

    public static int findRequiredNum(int arr[], int N) {
        int countSetBit[] = new int[32];

        for (int i = 0; i < arr.length; i++) {

            for (int k = 0; k < 32; k++) {
                int kthSetBit = 1 << k;
                if ((arr[i] & kthSetBit) == kthSetBit)
                    countSetBit[k]++;
            }
        }

        int occurredOnce = 0;

        for (int i = 0; i < 32; i++) {
            countSetBit[i] = countSetBit[i] % N;
            if (countSetBit[i] == 1)
                occurredOnce = occurredOnce | (1 << i);
        }
        return occurredOnce;
    }

}
