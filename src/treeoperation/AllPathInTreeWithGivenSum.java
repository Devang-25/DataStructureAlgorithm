package treeoperation;

import java.util.ArrayList;

public class AllPathInTreeWithGivenSum {

    public static ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        solve(root, sum, new ArrayList<>());
        return result;
    }

    public void solve(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root.left == null && root.right == null && root.val == sum) {
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            solve(root.left, sum - root.val, path);
        }
        if (root.right != null) {
            solve(root.right, sum - root.val, path);
        }
        path.remove(path.size() - 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            val = data;
        }
    }
}
