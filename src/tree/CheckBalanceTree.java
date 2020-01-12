package tree;

public class CheckBalanceTree {

    private Node root;

    public static void main(String[] args) {
        CheckBalanceTree tree = new CheckBalanceTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

        System.out.println(isBalanceTree(tree.root, new Height()));
    }

    private static boolean isBalanceTree(Node root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lh = new Height();
        Height rh = new Height();

        boolean isLeftBalance = isBalanceTree(root.left, lh);
        boolean isRightBalance = isBalanceTree(root.right, rh);
        height.height = Math.max(lh.height, rh.height) + 1;

        if ((lh.height - rh.height > 1) || (rh.height - lh.height > 1)) {
            return false;
        } else {
            return isLeftBalance && isRightBalance;
        }
    }

    private static class Height {
        int height;
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
