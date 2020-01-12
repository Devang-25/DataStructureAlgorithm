package tree;

public class PrintBSTWithinRange {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBinaryTreeRandomData();
        BinaryTree.printTree(root);
        printBSTWithinRange(root, 0, 4);
    }

    public static void printBSTWithinRange(BinaryTree root, int k1, int k2) {
        if (root == null) return;
        if (root.getData() >= k1)
            printBSTWithinRange(root.getLeft(), k1, k2);

        if (root.getData() >= k1 && root.getData() <= k2)
            System.out.println(root.getData());

        if (root.getData() <= k2)
            printBSTWithinRange(root.getRight(), k1, k2);
    }
}
