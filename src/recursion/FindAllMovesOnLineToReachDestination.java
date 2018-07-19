package recursion;

import java.util.HashSet;
import java.util.Scanner;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 27:7:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - recursion.FindAllMovesOnLineToReachDestination                   *
 * Last modified - 7/27/18 12:14 PM                                           *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class FindAllMovesOnLineToReachDestination {

    private static HashSet<String> data = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String moveStr = scanner.nextLine();
        int N = scanner.nextInt();
        int source = scanner.nextInt();
        int dest = scanner.nextInt();

        getAllCombinations(moveStr, new StringBuffer(), 0);
        System.out.println(getData(data, source, dest));


    }


    static void getAllCombinations(String instr, StringBuffer ansString, int index) {

        for (int i = index; i < instr.length(); i++) {
            ansString.append(instr.charAt(i));
            data.add(ansString.toString());
            getAllCombinations(instr, ansString, i + 1);
            ansString.deleteCharAt(ansString.length() - 1);
        }
    }

    private static int getData(HashSet<String> all, int source, int dest) {
        int totalMoves = 0;
        for (String s : all) {
            int start = source;
            for (char ch : s.toCharArray()) {
                if (ch == 'r') {
                    start++;
                } else {
                    start--;
                }
            }
            if (start == dest) {
                totalMoves++;
            }
        }

        return totalMoves;
    }

}
