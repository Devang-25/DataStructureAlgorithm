package dp;

/**
 * Created by : Rakesh Gupta on 8/8/17
 * Package : dp
 */
public class MinJumpToReachEnd {
    public static void main(String[] args) {
        int arr[] = {1,3,5,3,2,2,6,1,6,8,9};
        int minCount = getMinJump(arr);
        System.out.println("Minimum number of jump to reach end  :  " + minCount);
    }

    private static int getMinJump(int[] arr) {

        int minJump[] = new int[arr.length];
        minJump[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            minJump[i] = Integer.MAX_VALUE-1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]+j >= i){
                    if (minJump[i] > minJump[j]+1){
                        minJump[i] = minJump[j]+1;
                    }
                }

            }
        }
        return minJump[minJump.length-1];
    }
}
