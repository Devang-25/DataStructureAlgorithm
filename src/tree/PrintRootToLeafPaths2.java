package tree;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class PrintRootToLeafPaths2 {
    private static int maxLen = 0;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {4, 6},
                {4, 7}
        }, 6)));
    }

    static int[] solve(int[][] edges, int N) {
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = Integer.MAX_VALUE;

        BinaryTree root = null;

        int path[] = new int[256];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        printPaths(root, path, 0, list);

        for(ArrayList<Integer> temp : list){
            if (temp.size() >= maxLen-1){
                temp.remove(temp.size()-1);
                int len = temp.size()/2;
                int data = temp.get(len);
                if(ans[0] > data){
                    ans[0] = data;
                    ans[1] = len;
                }
            }
        }
        return ans;
    }

     static void printPaths(BinaryTree root, int[] path, int pathLen, ArrayList<ArrayList<Integer>> list) {
        if (root == null )
            return;

        path[pathLen] = root.data;
        pathLen++;

        if (root.left == null && root.right == null ) {
            printArray(path, pathLen, list);
        } else {
            printPaths(root.left, path, pathLen, list);
            printPaths(root.right, path, pathLen, list);
        }
    }

     static void printArray(int[] path, int pathLength, ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> l = new ArrayList<>();
        if(pathLength >= maxLen){
            for (int i=0; i<pathLength; i++){
                l.add(path[i]);
            }
            list.add(l);
            maxLen = Math.max(maxLen, pathLength);
        }
    }

    static class BinaryTree {
        int data;
        BinaryTree left, right;
        public BinaryTree(int d){
            data = d;
        }
    }
}
