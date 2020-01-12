package array;

import java.util.ArrayList;

public class PrettyPrint {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> out = prettyPrint(4);
        for (ArrayList<Integer> r : out) {
            for (Integer d : r) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> prettyPrint(int num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int size = num;
        int count = num;
        for (int i = 0; i < size; i++) {
            int inc = i;
            ArrayList<Integer> row = new ArrayList<>();
            while (count > 0 && row.size() < num) {
                row.add(count);
                if (inc - 1 >= 0) {
                    count = count - 1;
                    inc = inc - 1;
                }
            }
            for (int j = row.size() - 2; j >= 0; j--) {
                row.add(row.get(j));
            }
            ans.add(row);
            count = num;
        }
        for (int i = ans.size() - 2; i >= 0; i--) {
            ans.add(ans.get(i));
        }
        return ans;
    }
}
