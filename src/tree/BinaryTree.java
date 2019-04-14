package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rakeshgupta on 7/9/17.
 */
public class BinaryTree {
    public BinaryTree left;
    public BinaryTree right;
    int data;

    public BinaryTree(int data) {
        this.data = data;
    }

    public static void postOrder(BinaryTree root) {
        if (root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public static void preOrder(BinaryTree root) {
        if (root == null)
            return;
        System.out.print(root.getData() + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BinaryTree root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.getData() + " ");
        inOrder(root.right);
    }

    public static void add(BinaryTree root, int data) {
        BinaryTree node = new BinaryTree(data);
        if (root == null)
            root = node;
        else
            traverseAndAddBinaryNode(root, node);
    }

    public static BinaryTree deleteNode(BinaryTree root, int value) {
        if (root == null) {
            return null;
        }
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);
        } else {

            if (root.left != null && root.right != null) {
                BinaryTree temp = root;
                BinaryTree minNodeFromRight = getMinNode(root.right);
                root.data = minNodeFromRight.data;
                deleteNode(root.right, minNodeFromRight.data);

            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    private static BinaryTree getMinNode(BinaryTree root) {
        if (root.left == null)
            return root;
        return getMinNode(root.left);
    }

    public static void traverseAndAddBinaryNode(BinaryTree root, BinaryTree node) {
        if (node.getData() < root.data) {
            if (root.getLeft() == null)
                root.left = node;
            else
                traverseAndAddBinaryNode(root.left, node);
        } else if (node.data > root.data) {
            if (root.right == null)
                root.right = node;
            else
                traverseAndAddBinaryNode(root.right, node);
        }
    }

    public static void printTree(BinaryTree root) {
        BTreePrinter bTreePrinter = new BTreePrinter();
        bTreePrinter.printNode(root);
    }

    public BinaryTree getLeft() {

        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    static class BTreePrinter {

        public static <T extends Comparable<?>> void printNode(BinaryTree root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<BinaryTree> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<BinaryTree> newNodes = new ArrayList<BinaryTree>();
            for (BinaryTree node : nodes) {
                if (node != null) {
                    System.out.print(node.data);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }
            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static <T extends Comparable<?>> int maxLevel(BinaryTree node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }
            return true;
        }
    }
}
