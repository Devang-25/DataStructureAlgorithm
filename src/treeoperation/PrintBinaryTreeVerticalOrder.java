package treeoperation;

import tree.BinaryTree;
import tree.BinaryTreeData;

/**
 * Created by : Rakesh Gupta on 8/20/17
 * Package : treeoperation
 */
public class PrintBinaryTreeVerticalOrder {
    Values values = new Values();
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getRandomPopulatedData();
        System.out.println("Vertical Order Traversal is : " );
       new PrintBinaryTreeVerticalOrder().verticalOrderTraverse(root);
    }

    private  void verticalOrderTraverse(BinaryTree root) {
            findMinMax(root, values, values, 0);
        for (int lineNum = values.min; lineNum <=values.max ; lineNum++) {
            printVerticalLine(root, lineNum, 0);
            System.out.println();
        }
    }

    private void printVerticalLine(BinaryTree root, int lineNum, int ss) {
        if (root == null)
            return;
        if (ss == lineNum)
            System.out.print(root.getData() + " ");

        printVerticalLine(root.left, lineNum, ss-1);
        printVerticalLine(root.right, lineNum, ss+1);
    }

    private void findMinMax(BinaryTree root, Values minVal, Values maxVal, int start) {
        if (root == null)
            return;
        if (start < minVal.min)
            minVal.min = start;
        else if (start > maxVal.max)
            maxVal.max = start;
        findMinMax(root.left, minVal, maxVal, start-1);
        findMinMax(root.right, minVal,maxVal, start+1);
    }

    class Values{
        int min, max;
    }
}
