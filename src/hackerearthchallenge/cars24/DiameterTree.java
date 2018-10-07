package hackerearthchallenge.cars24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DiameterTree {

    private static int first;
    private static int last;
    private static int maxCount;
    private static List<Integer>[] adjList;

    private static void findDeepestNode(int node, int count,
                                        boolean visited[],
                                        List<Integer> adj[]) {
        visited[node] = true;
        count++;

        List<Integer> adjacentNodes = adj[node];
        for (Integer currNode : adjacentNodes) {
            if (!visited[currNode]) {
                if (count >= maxCount) {
                    maxCount = count;
                    first = currNode;
                }
                findDeepestNode(currNode, count, visited, adj);
            }
        }
    }

    private static void traverseDFS(int node, int n, List<Integer>
            adj[]) {
        boolean[] visited = new boolean[n + 1];
        int count = 0;

        Arrays.fill(visited, false);

        findDeepestNode(node, count + 1, visited, adj);

    }

    private static int getLongestDiameter(List<Integer> adj[], int size) {
        maxCount = Integer.MIN_VALUE;
        traverseDFS(1, size, adj);
        last = first;
        traverseDFS(first, size, adj);
        return maxCount;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        adjList = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++)
            adjList[i] = new ArrayList<>();

        for (int j = 0; j < n - 1; j++) {
            int f = input.nextInt();
            int l = input.nextInt();
            adjList[f].add(l);
            adjList[l].add(f);
        }

        getLongestDiameter(adjList, n);
        System.out.println(first + " " + last);
    }
}