package dsalgo_made_easy_karumanchi.tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class InsertElementInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        BinaryTree b = insertNodeInBinaryTree(binaryTree, 25);
        //Verify inserted element in tree
        System.out.println(SearchingElementInBinaryTreeRecursion.searchInBinaryTree(b, 25));
    }
    public static BinaryTree insertNodeInBinaryTree(BinaryTree root, int data){
        if (root == null)
            root = new BinaryTree(data);
        else
            insertNode(root, data);
        return root;
    }

    private static void insertNode(BinaryTree root, int data) {
            if (root.getData() >= data){
                if (root.getLeft() == null)
                    root.left = new BinaryTree(data);
                else
                    insertNode(root.right, data);
            }else {
                if (root.getRight() == null)
                    root.right = new BinaryTree(data);
                else
                    insertNode(root.right, data);
            }
    }
}
