package leetcode.dfs;

import linkedlist.ListNode;
import tree.model.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    private static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(10);
        head.next.next.next.next = new ListNode(12);
        TreeNode root = sortedListToBST(0, 4);
        TreeNode.printTreeNode(root);
    }

    public static TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(head.data);
        parent.setLeft(leftChild);
        head = head.next;
        parent.setRight(sortedListToBST(mid + 1, end));
        return parent;
    }
}
