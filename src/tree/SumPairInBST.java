package tree;

import java.util.HashSet;
import java.util.Set;

public class SumPairInBST {

    Set<Integer> set = new HashSet<>();

    public int findSumPair(TreeNode a, int sum) {
        if (a == null) return 0;
        if (set.contains(sum - a.val)) {
            return 1;
        }
        set.add(a.val);
        return Math.max(findSumPair(a.left, sum), findSumPair(a.right, sum));
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
