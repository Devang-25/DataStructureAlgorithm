package hackerearthchallenge.wissen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindingSubArraysSolution {

    private static int ans;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double inArr[] = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            inArr[i] = scanner.nextDouble();
        }

        Map<Integer, ArrayList<Integer>> subArrPairMap = getSubArrPair(n, inArr);
        System.out.println(ans);

        for (Integer set : subArrPairMap.keySet()) {
            ArrayList<Integer> setValues = subArrPairMap.get(set);
            for (int j = 0; j < setValues.size(); j++) {
                System.out.println(set + " " + setValues.get(j));
            }
        }
        scanner.close();
    }

    private static Map<Integer, ArrayList<Integer>> getSubArrPair(int n, double inArr[]) {

        double sumArr[] = new double[n + 1];
        sumArr[1] = inArr[1];
        for (int i = 2; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + inArr[i];
        }
        double totalSum = sumArr[n];
        ArrayList<Integer> currList;

        Map<Integer, ArrayList<Integer>> arrayListHashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int elm = j - i + 1;
                double currSum = (sumArr[j] - sumArr[i - 1]);
                double currAvg = currSum / elm;
                int currRem = n - elm;

                if (currRem == 0 || currAvg > ((totalSum - currSum) / currRem)) {
                    ans++;
                    if (arrayListHashMap.containsKey(i)) {
                        currList = arrayListHashMap.get(i);
                        currList.add(j);
                    } else {
                        currList = new ArrayList<>();
                        currList.add(j);
                    }
                    arrayListHashMap.put(i, currList);
                }
            }
        }
        return arrayListHashMap;
    }
}

