package dsalgo_made_easy_karumanchi.tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SearchingElementInBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Status of Searched Element in Binary Tree  is : " + searchInBinaryTree(binaryTree, 5));
    }
    public static boolean searchInBinaryTree(BinaryTree root, int data){
        if (root == null )
            return false;
        if (root.getData() == data)
            return true;

        return searchInBinaryTree(root.getLeft(), data) || searchInBinaryTree(root.getRight(), data);
    }
}
