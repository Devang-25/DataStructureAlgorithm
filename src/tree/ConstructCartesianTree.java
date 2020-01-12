package tree;

import tree.model.TreeNode;

import java.util.ArrayList;

public class ConstructCartesianTree {
    public TreeNode buildTree(ArrayList<Integer> A) {
        return buildInorderTree(A, 0, A.size() - 1);
    }

    public TreeNode buildInorderTree(ArrayList<Integer> arrayList, int start, int end) {
        if (start > end) return null;

        int idx = findMax(arrayList, start, end);
        TreeNode root = new TreeNode(arrayList.get(idx));

        root.left = buildInorderTree(arrayList, start, idx - 1);
        root.right = buildInorderTree(arrayList, idx + 1, end);

        return root;
    }

    public int findMax(ArrayList<Integer> A, int start, int end) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = start; i <= end; i++) {
            if (max < A.get(i)) {
                max = A.get(i);
                idx = i;
            }
        }
        return idx;
    }
}
