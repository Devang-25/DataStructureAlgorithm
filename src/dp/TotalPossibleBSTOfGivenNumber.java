package dp;

/**
 * Created by rakeshgupta on 7/28/17.
 */
public class TotalPossibleBSTOfGivenNumber {
    public static void main(String[] args) {
        int num = 3;
        int totalNumberOfBSTOfGivenNumber = getTotalBST(num);
        System.out.println(totalNumberOfBSTOfGivenNumber);
    }

    private static int getTotalBST(int num) {
        int T[] = new int[num+1];
    
        T[0] = T[1] = 1;
        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                T[i]  += T[j] * T[i-j-1];
            }
        }

        return T[num];
    }
}
