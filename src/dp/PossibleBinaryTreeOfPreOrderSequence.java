package dp;

/**
 * Created by rakeshgupta on 8/1/17.
 */
public class PossibleBinaryTreeOfPreOrderSequence {
    public static void main(String[] args) {
       int seq = 3;

       int T[] = new int[seq+1];
        T[0] = 1;
        T[1] = 1;
        for (int i = 2; i <= seq; i++) {
            for (int j = 0; j < i; j++) {
                T[i] += T[j] * T[i-j-1];
            }
        }

        System.out.println("Total no of PreOrder Binary Tree Possible from a preorder Traversal : " + T[seq]);
    }
}
