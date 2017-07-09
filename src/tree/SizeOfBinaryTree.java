package tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SizeOfBinaryTree {
    public static void main(String[] args) {
    BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Size of Tree : " + sizeOfTree(binaryTree));
    }


    private static int sizeOfTree(BinaryTree root) {
        int size = 0;
        if (root == null )
            return 0;
        Queue<BinaryTree> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree temp  = queue.poll();
                size++;
            if (temp.getLeft() != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return size;
    }
}
