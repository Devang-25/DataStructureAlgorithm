package leetcode.dfs;

// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

import tree.model.TreeNode;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Arrays.asList(new int[] { 3, 5});
        TreeNode root = helper(nums, 0, nums.length - 1);

        return root;
    }


    private TreeNode helper(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode current = new TreeNode(nums[mid]);
            current.left = helper(nums, start, mid - 1);
            current.right = helper(nums, mid + 1, end);
            return current;
        }
        return null;
    }
}
