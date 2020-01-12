package treeoperation;


import tree.BinaryTree;
import tree.BinaryTreeData;

import java.util.ArrayList;
import java.util.List;

public class PrintPathTree {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBinaryTreeRandomData();
        BinaryTree.printTree(root);
        printPath(root, new ArrayList<>());
    }

    private static void printPath(BinaryTree root, List<Integer> integers) {
        if (root == null)
            return;

        if (root.getLeft() == null && root.getRight() == null) {
            System.out.print(root.getData() + " ");
            print(integers);
        }
        printPath(root.left, addNum(integers, root.getData()));
        printPath(root.right, addNum(integers, root.getData()));
    }

    private static void print(List<Integer> list){
        for (Integer data: list){
            System.out.print(data.intValue() + " ");
        }
        System.out.println();
    }

    private static List<Integer> addNum(List<Integer> list, int num){
        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        temp.add(num);
        return temp;
    }
}
