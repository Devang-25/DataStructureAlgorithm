package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SearchingElementInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Searched Status : " + searchDataInBinaryTree(binaryTree, 79));

    }

    public static boolean searchDataInBinaryTree(BinaryTree root, int data){
        if (root == null )
            return false;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            if (temp.getData() == data)
                return true;

            if (temp != null){
                if (temp.getLeft() != null)
                    queue.offer(temp.getLeft());

                if (temp.getRight() != null)
                    queue.offer(temp.getRight());
            }
        }
        return false;
    }

}
