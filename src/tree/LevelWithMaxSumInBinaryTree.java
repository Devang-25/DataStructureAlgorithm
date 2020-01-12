package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class LevelWithMaxSumInBinaryTree {
    public static void main(String[] args) {
//        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        BinaryTree binaryTree = BinaryTreeData.getBinaryTreeRandomData();
        BinaryTree.printTree(binaryTree);
        System.out.println("Level with max sum in Binary tree : " + maxSumLevelInBinaryTree(binaryTree));
        System.out.println("Level with max sum in Binary tree-2 : " + maxSumLevel(binaryTree));
    }

    private static int maxSumLevelInBinaryTree(BinaryTree root) {
        int maxSum = 0, currentSum = 0;
        if (root == null)
            return 0;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()){
            BinaryTree tmp = queue.poll();
            if (tmp != null){
                if (tmp.left != null)
                    queue.offer(tmp.left);
                if (tmp.right != null)
                    queue.offer(tmp.right);
            }else {
                if (currentSum > maxSum)
                    maxSum = currentSum;
                currentSum = 0;
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return maxSum;
    }

    private static int maxSumLevel(BinaryTree root){
        if (root == null) return 0;

        int maxSum = 0;
        Queue<BinaryTree> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int count = q.size();
            int tempSum = 0;
            for (int i = 0; i <count; i++) {
                BinaryTree curr = q.poll();
                tempSum += curr.getData();
                if (curr.getLeft() != null)
                    q.offer(curr.left);
                if (curr.getRight() != null)
                    q.offer(curr.right);
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}
