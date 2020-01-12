package tree;


/**
 * Created by rakeshgupta on 4/2/17.
 */
public class PrintRootToLeafPaths {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        BinaryTree.printTree(binaryTree);
        printPaths(binaryTree);
    }

    public static void printPaths(BinaryTree root){
        int path[] = new int[256];
        printPaths(root, path, 0);
    }

    private static void printPaths(BinaryTree root, int[] path, int pathLen) {
        if (root == null )
            return;

        path[pathLen] = root.getData();
        pathLen++;

        if (root.getLeft() == null && root.getRight() == null ) {
            printArray(path, pathLen);
        } else {
            printPaths(root.getLeft(), path, pathLen);
            printPaths(root.getRight(), path, pathLen);
        }
    }

    private static void printArray(int[] path, int pathLength) {
            for (int i=0; i<pathLength; i++)
                System.out.print(path[i] + " ");
                System.out.println();
    }
}
