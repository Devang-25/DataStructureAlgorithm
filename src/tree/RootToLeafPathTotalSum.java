package tree;

public class RootToLeafPathTotalSum {

    public int sumNums(TreeNode A) {
        return sum(A, 0) % 1003;
    }

    public int sum(TreeNode root, int multiplyNum) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return (multiplyNum * 10 + root.val) % 1003;
        }

        int num = multiplyNum * 10 + root.val;
        num %= 1003;
        int ans = (sum(root.left, num) + sum(root.right, num));

        return ans % 1003;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }
}
