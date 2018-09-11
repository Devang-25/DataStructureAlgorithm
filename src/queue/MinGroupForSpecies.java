package queue;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/******************************************************************************
 * Creation Date - 3:8:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - queue.MinGroupForSpecies                                         *
 * Last modified - 8/3/18 2:37 PM                                             *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class MinGroupForSpecies {

    private static int count = 0;

    public static void main(String[] args) {

        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        getMinGroup(arr);
        System.out.println(count - 1);
    }

    private static void getMinGroup(int[] arr) {

        Queue<Integer> tempQueue = new LinkedList<>();
        Queue<Integer> queue = getPredatorFromSpecies(-1, arr);
        count++;
        do {
            while (!queue.isEmpty()) {
                int data = queue.poll();
                tempQueue.addAll(getPredatorFromSpecies(data, arr));
            }
            queue = tempQueue;
            tempQueue = new LinkedList<>();
            count++;
        } while (!queue.isEmpty());
    }

    private static Queue<Integer> getPredatorFromSpecies(int d, int[] arr) {
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == d)
                queue.add(i);
        }
        return queue;
    }
}
