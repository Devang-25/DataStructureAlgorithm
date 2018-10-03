package hackerearthchallenge.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Bit Flipping Game <Nissan>
 *
 * Two players
 * and are playing a game.They are given binary numbers as input. Each binary number is represented as a string of characters '0'
 * or '1'. The string always ends at '1'.  In one move each player decides a bit position . Then he visits all the numbers and if their bit at that position is '1' then he changes it to '0'. It is mandatory to flip(change '1' to '0') bit of atleast one number in each move. The player who is unable to make a move loses. Player
 *
 * begins the game.
 *
 * Input
 * First line contains a number
 * as input. Next
 *
 * lines contain a binary string each.
 *
 * Output
 * Print A if player A wins , B otherwise. In the next line print the move number of the last move of the winning player.
 *
 * Constraints
 *
 * where
 *
 * is sum of length of all bit strings.
 *
 *
 *
 * Some important information -
 * Suppose that the length of the string
 * in input is then is the bit , is the first bit and so on is the
 *
 *  bit. All the other bit for that string are assumed as zeros.
 *
 * Note: Go through the sample explanation carefully
 * Sample Input
 *
 * 2
 * 01
 * 001
 * Sample Output
 *
 * B
 * 2
 */
public class BitFlippingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine());
        String arr[] = new String[N];

        for (int i=0; i<N; i++){
            arr[i] = input.nextLine();
        }

        int bitArr[] = new int[1000000];

        for (String num : arr){
            char numArr[] = num.toCharArray();
            for (int i = 0; i < numArr.length; i++) {
                 if (numArr[i] == '1'){
                     bitArr[i] = 1;
                 }
            }
        }
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
             if (bitArr[i] == 1)
                 count++;
        }

        if (count % 2 == 0){
            System.out.println("B");
            System.out.println(count);
        }else {
            System.out.println("A");
            System.out.println(count);
        }
    }
}
