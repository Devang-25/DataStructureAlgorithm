package dsalgo_made_easy_karumanchi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class NumberOfFullNodeInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Number of Full node in Binary Tree : " + numberOfFullNodeInBinaryTree(binaryTree));
    }

    private static int numberOfFullNodeInBinaryTree(BinaryTree root) {
        int count = 0;
        if (root == null )
            return 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree tmp = queue.poll();
            if (tmp.getLeft() != null && tmp.getRight() != null)
                count++;
            if (tmp.left != null)
                queue.offer(tmp.left);
            if (tmp.right != null)
                queue.offer(tmp.right);
        }
        return count;
    }
}
