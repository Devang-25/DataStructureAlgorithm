package tree;

import tree.model.TreeNode;

import java.util.ArrayList;

public class BinartTreeFromInorderPreorder {

    int bEnd = 0;

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0) return null;
        bEnd = 0;
        return constructBT(B, A, 0, B.size() - 1);
    }

    public TreeNode constructBT(ArrayList<Integer> A, ArrayList<Integer> B, int aStart, int aEnd) {
        if (aStart > aEnd) return null;
        if (bEnd == B.size()) return null;

        TreeNode root = new TreeNode(B.get(bEnd++));
        if (aStart == aEnd) return root;

        int idx = findIdx(A, aStart, aEnd, root.val);
        root.left = constructBT(A, B, aStart, idx - 1);
        root.right = constructBT(A, B, idx + 1, aEnd);

        return root;
    }

    public int findIdx(ArrayList<Integer> A, int start, int end, int num) {
        for (int i = start; i <= end; i++) {
            if (A.get(i) == num) return i;
        }
        return -1;
    }
}
