package tree;


import java.util.Stack;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class HeightOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Height of Tree : " + heightOfBinaryTree(binaryTree));
    }

    public static int heightOfBinaryTree(BinaryTree root) {
        if (root == null )
            return 0;

        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        int maxDepth = 0;
        BinaryTree prev = null;

        while (!stack.isEmpty()){
            BinaryTree curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr){
                if (curr.left != null)
                    stack.push(curr.left);
                else if (curr.right != null)
                    stack.push(curr.right);
            }else if (curr.left == prev){
                if (curr.right != null)
                    stack.push(curr.right);
            }
            else
                stack.pop();

                prev = curr;
                if (stack.size() > maxDepth)
                    maxDepth = stack.size();
        }
        return maxDepth;
    }
}
