package dsalgo_made_easy_karumanchi.tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class MaxElementInBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println(maxInBinaryTree(binaryTree));
    }

    public static int maxInBinaryTree(BinaryTree root){
        int maxValue = Integer.MIN_VALUE;
        if (root != null ){
            int leftMax = maxInBinaryTree(root.getLeft());
            int rightMax = maxInBinaryTree(root.getRight());
            if (leftMax > rightMax)
                maxValue = leftMax;
            else
                maxValue = rightMax;

            if (root.getData() > maxValue)
                maxValue = root.getData();
        }
        return maxValue;
    }
}
