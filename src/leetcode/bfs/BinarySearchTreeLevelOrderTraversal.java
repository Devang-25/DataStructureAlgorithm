package leetcode.bfs;

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

import tree.BinaryTreeData;
import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinarySearchTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeData.getTreeNodeData();
        System.out.println(new BinarySearchTreeLevelOrderTraversal().levelOrder2(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> tempList = new ArrayList<Integer>();
        tempList.add(root.val);
        result.add(tempList);
        while (!queue.isEmpty()) {
            Queue<TreeNode> currentLevel = new LinkedList<>();
            List<Integer> list = new ArrayList<Integer>();
            while (!queue.isEmpty()) {
                TreeNode current = queue.remove();
                if (current.left != null) {
                    currentLevel.add(current.left);
                    list.add(current.left.val);
                }
                if (current.right != null) {
                    currentLevel.add(current.right);
                    list.add(current.right.val);
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
            queue = currentLevel;
        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (a == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);
        int size = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
            list.add(curNode.val);
            if (--size == 0) {
                ans.add(new ArrayList<>(list));
                list.clear();
                size = queue.size();
            }
        }
        return ans;
    }
}
