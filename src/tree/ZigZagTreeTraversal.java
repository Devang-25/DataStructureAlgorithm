package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ZigZagTreeTraversal {

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> zigZagTraversal(TreeNode root) {
        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            populateLavelData(root, i, 1);
        }
        for (int i = 1; i <= height; i++) {
            ArrayList<Integer> temp = map.get(i);
            if (i % 2 == 0) {
                Collections.reverse(temp);
            }
            ans.add(temp);
        }
        return ans;
    }

    public void populateLavelData(TreeNode root, int level, int actualLevel) {
        if (root == null) return;
        if (level == 1) {
            ArrayList<Integer> temp;
            if (!map.containsKey(actualLevel)) {
                temp = new ArrayList<>();
            } else {
                temp = map.get(actualLevel);
            }

            temp.add(root.val);
            map.put(actualLevel, temp);
        } else {
            populateLavelData(root.left, level - 1, actualLevel + 1);
            populateLavelData(root.right, level - 1, actualLevel + 1);
        }
    }

    public int getHeight(TreeNode A) {
        if (A == null) return 0;
        return 1 + Math.max(getHeight(A.left), getHeight(A.right));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
