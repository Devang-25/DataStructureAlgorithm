package leetcode.backtracking;//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
  //[1,2,3],
  //[1,3,2],
  //[2,1,3],
  //[2,3,1],
  //[3,1,2],
  //[3,2,1]
//]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Permutations {
    private static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for (int n: nums) {
            int size = result.size();
            while(size > 0) {
                List<Integer> current = result.pollFirst();
                for (int i = 0; i <= current.size(); i++) {
                    List<Integer> temp = new ArrayList<>(current);
                    temp.add(i, n);
                    result.add(temp);
                }
                size--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
