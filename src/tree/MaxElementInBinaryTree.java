package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class MaxElementInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println(maxDataInBinaryTree(binaryTree));
    }

    private static int maxDataInBinaryTree(BinaryTree root) {

        if (root == null )
            return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree node = queue.poll();
            if (node.getData() > max)
                max = node.getData();

            if (node != null){
                if (node.getLeft() != null)
                    queue.offer(node.getLeft());

                if (node.getRight() != null)
                    queue.offer(node.getRight());
            }
        }
        return max;
    }

}
