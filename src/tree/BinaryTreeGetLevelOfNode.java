package tree;

public class BinaryTreeGetLevelOfNode {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBSTData(6, 20);
        BinaryTree.printTree(root);
        int level = getLevelOfNode(root, 5, 0);
        System.out.println("Level of node 9 in binary tree is : " + level);
    }

    private static int getLevelOfNode(BinaryTree root, int key, int level) {
        if (root == null)
            return 0;

        if (root.data == key)
            return level;

        int result = getLevelOfNode(root.left, key, level + 1);
        if (result != 0)
            return result;

        result = getLevelOfNode(root.right, key, level + 1);
        return result;
    }
}
