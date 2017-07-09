package tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class NumberOfHalfNodeInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Number of Half Node in BinaryTree : " + numberOfHalfNodeInBinaryTree(binaryTree));
    }

    private static int numberOfHalfNodeInBinaryTree(BinaryTree root) {
        int count = 0;
        if (root == null)
            return 0;

        Queue<BinaryTree> queue  = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree tmp = queue.poll();
            if ((tmp.getLeft() == null && tmp.getRight() != null) || (tmp.getRight() == null && tmp.getLeft() != null))
                count++;
            if (tmp.left != null)
                queue.offer(tmp.left);
            if (tmp.right != null)
                queue.offer(tmp.right);
        }
        return count;
    }
}
