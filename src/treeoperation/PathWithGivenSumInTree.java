package treeoperation;

import java.util.ArrayList;

public class PathWithGivenSumInTree {
    public ArrayList<ArrayList<Integer>> findAllPathWithGivenSum(TreeNode root, int sum){
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        int path[] = new int[256];
        getAllPaths(root, allPaths, path, sum, 0);
        return allPaths;
    }

    private void getAllPaths(TreeNode root, ArrayList<ArrayList<Integer>> allPaths, int[] path, int sum, int pathLen) {
        if (root == null) return;
        path[pathLen] = root.val;
        pathLen++;

        if (root.left == null && root.right == null){
            int tempSum = 0;
            for (int i=0; i<pathLen; i++){
                tempSum += path[i];
            }
            if (tempSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=0; i<pathLen; i++){
                    list.add(path[i]);
                }
                allPaths.add(list);
            }
        }else {
            getAllPaths(root.left, allPaths, path, sum, pathLen);
            getAllPaths(root.right, allPaths, path, sum, pathLen);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            val = data;
        }
    }
}
