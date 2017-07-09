package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class PrintLevelOrderDataInReverseOrder {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        printInReverseOrder(binaryTree);
    }

    private static void printInReverseOrder(BinaryTree root) {
            if (root == null)
                return;
        Stack<BinaryTree> stack = new Stack<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree tmp = queue.poll();
            if (tmp.left != null)
                queue.offer(tmp.left);
            if (tmp.right != null)
                queue.offer(tmp.right);
            stack.push(tmp);
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop().getData() + " ");
    }
}
