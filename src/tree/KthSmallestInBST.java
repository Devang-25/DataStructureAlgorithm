package tree;

import java.util.Stack;

public class KthSmallestInBST {

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBinaryTreeRandomData();
        BinaryTree.printTree(root);
        KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
        System.out.println("Iterative :: " + kthSmallestInBST.kthSmallest(root, 3));
        System.out.println("Recursion :: " + kthSmallestInBST.kthSmallestNodeBST(root, 3, 0).getData());
    }

    public int kthSmallest(BinaryTree A, int k) {
        Stack<BinaryTree> stack = new Stack<>();

        while (A != null) {
            stack.push(A);
            A = A.left;
        }

        while (k != 0) {
            BinaryTree n = stack.pop();
            k--;
            if (k == 0) return n.getData();
            BinaryTree right = n.right;

            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }

    public BinaryTree kthSmallestNodeBST(BinaryTree root, int k, int count) {
        if (root == null) return null;

        BinaryTree left = kthSmallestNodeBST(root.getLeft(), k, count);
        if (left != null) return left;
        if (++count == k) return root;
        return kthSmallestNodeBST(root.getRight(), k, count);
    }
}
