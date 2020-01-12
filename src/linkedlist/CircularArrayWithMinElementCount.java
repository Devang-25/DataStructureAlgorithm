package linkedlist;

import java.util.*;

public class CircularArrayWithMinElementCount {
    public static void main(String[] args) {
        int n = 10;
        int q = 4;
        List<Integer> arr = new ArrayList<>();
//        int[]{
//                1, 5, 10, 5
//        };
        int ans = findMin(n, n, arr);
        System.out.println(ans);
    }

    private static int findMin(int num, int n, List<Integer> arr) {
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int first = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int a = arr.get(i);
            prepare(num, first, a, freq);
            first = a;
        }

        return Collections.max(freq.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    private static void prepare(int num, int first, int a, Map<Integer, Integer> freq) {
        if (first < num){
            for (int i=first;i<a;i++){
                freq.put(i, freq.getOrDefault(i, 0)+1);
            }
        }else {
            for (int i=first;i<num;i++){
                freq.put(i, freq.getOrDefault(i, 0)+1);
            }
            for (int i=0;i<a;i++){
                freq.put(i, freq.getOrDefault(i, 0)+1);
            }
        }
    }
}
