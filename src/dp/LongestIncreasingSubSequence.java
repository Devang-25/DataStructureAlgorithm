package dp;

/**
 * Created by rakeshgupta on 8/2/17.
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 4, -1, 0, 6, 2, 3};

        int lenOfLongestIncreasingSubSeq = getLIncreasingSubseq(arr);
        System.out.println("Longest Increasing sub sequence : " + lenOfLongestIncreasingSubSeq);
    }

    private static int getLIncreasingSubseq(int[] arr) {

        int subSeqArr[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];

        for (int i = 0; i <arr.length ; i++) {
            subSeqArr[i] = 1;
            actualSolution[i] = i;
        }

        for (int i = 1  ; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    if ((subSeqArr[j]+1) > subSeqArr[i]){
                        subSeqArr[i] = subSeqArr[j]+1;
                        actualSolution[i] = j;
                    }
                }

            }
        }

        int maxIndex = 0;
        for (int i = 0; i < subSeqArr.length; i++) {
            if (subSeqArr[i] >  subSeqArr[maxIndex])
                maxIndex = i;
        }

        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();

        return subSeqArr[maxIndex];
    }
}
