package leetcode.tree;

//Given a binary search tree and the lowest and highest boundaries as L and R, trim the
//tree so that all its elements lies in [L, R] (R >= L). You might need to change the root 
//of the tree, so the result should return the new root of the trimmed binary search tree.


import tree.BinaryTree;
import tree.BinaryTreeData;

class TrimABinarySearchTree {

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBinaryTreeRandomData();
        BinaryTree.printTree(root);
        TrimABinarySearchTree trimABinarySearchTree = new TrimABinarySearchTree();
        trimABinarySearchTree.trimBST(root, 1,5);
        BinaryTree.printTree(root);
    }

    public BinaryTree trimBST(BinaryTree root, int L, int R) {
        if(root == null) {
            return root;
        }
        if(root.getData() < L) {
            return trimBST(root.right, L, R);
        }
        if(root.getData() > R) {
            return trimBST(root.left, L, R);
        }
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
