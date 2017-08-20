package treeoperation;

import tree.BinaryTree;
import tree.BinaryTreeData;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by : Rakesh Gupta on 8/20/17
 * Package : treeoperation
 */
public class PrintBinaryTreeTopView {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBSTData(5, 50);

        System.out.println("Binary Tree Top View is : ");
        new PrintBinaryTreeTopView().printTopView(root);
    }

    private void printTopView(BinaryTree root) {
        if (root == null)
            return;

        HashSet<Integer> integerHashSet = new HashSet<>();
        Queue<QItem> qItems = new LinkedList<>();
        qItems.add(new QItem(root, 0));

        while (!qItems.isEmpty()){
            QItem q = qItems.remove();
            int hd = q.hd;
            BinaryTree n = q.node;

            if (!integerHashSet.contains(hd)){
                integerHashSet.add(hd);
                System.out.print(n.getData() + " ");
            }

            if (n.left != null)
                qItems.add(new QItem(n.left, hd-1));
            if (n.right != null)
                qItems.add(new QItem(n.right, hd+1));
        }

    }

    class QItem {
        BinaryTree node;
        int hd;
        public QItem(BinaryTree n, int h) {
            node = n;
            hd = h;
        }
    }
}
