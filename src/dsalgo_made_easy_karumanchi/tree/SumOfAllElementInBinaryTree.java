package dsalgo_made_easy_karumanchi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SumOfAllElementInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Sum of all element : " + sumOfAllElement(binaryTree));
    }

    private static int sumOfAllElement(BinaryTree root) {
        int sum = 0;
        if (root == null)
            return 0;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree tmp = queue.poll();
            sum += tmp.getData();
            if (tmp.left != null)
                queue.offer(tmp.left);
            if (tmp.right != null)
                queue.offer(tmp.right);
        }
        return sum;
    }
}
