package dsalgo_made_easy_karumanchi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class DeepestNodeOfBinaryTree {
    public static void main(String[] args) {
    BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Deepest Node of Binary Tree : " + deepestNodeOfTree(binaryTree).getData());
    }

    private static BinaryTree deepestNodeOfTree(BinaryTree root) {
        BinaryTree tmp = null;
        if (root == null)
            return null;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            tmp = queue.poll();
            if (tmp.left != null)
                queue.offer(tmp.left);
            if (tmp.right != null)
                queue.offer(tmp.right);
        }
        return tmp;
    }

}
