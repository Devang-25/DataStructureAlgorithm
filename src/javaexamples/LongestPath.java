package javaexamples;

import java.util.*;

public class LongestPath {

    //Graph
    Map<Integer, Set<Integer>> graph;
    int graphSize;
    int startingVertex;
    int count;

    //Search
    boolean[] discovered;
    int[] parent;
    int time;

    //Topological sort
    ArrayDeque<Integer> sort;

    public static void main(String args[]) {
        LongestPath lp = new LongestPath();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            lp.read(in.nextLine());
        }
    }

    /**
     * Parses input, a sequence of
     * n:graph siz
     * x: starting vertex
     * i j: edge from i to j
     * 0 0: end of graph
     *
     * @param s input string
     */
    public void read(String s) {
        String[] input = s.split(" ");
        if (input.length == 1) { //new graph, initialize everything
            if (startingVertex != -1) {
                graphSize = Integer.parseInt(input[0]);
                graph = new HashMap<Integer, Set<Integer>>();
                startingVertex = -1;
                count++;
            } else
                startingVertex = Integer.parseInt(input[0]);
        } else {
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            if (from == 0 && to == 0)
                longestDistance();
            else
                insertEdge(from, to, true);
        }
    }

    public void longestDistance() {
        //initiate DFS and topological sort
        discovered = new boolean[graphSize + 1];
        parent = new int[graphSize + 1];
        sort = new ArrayDeque<Integer>();

        //do topological sort
        depthFirstSearch(startingVertex);

        //Compute the length of the longest path ending at v by looking at its incoming
        //neighbors and adding one to the maximum length recorded for those neighbors.
        int[] longestDistance = new int[graphSize + 1];
        for (int from : sort)
            for (int to : graph.get(from))
                longestDistance[to] = Math.max(longestDistance[to], longestDistance[from] + 1);

        //Starting from longest distance, step back to node with next highest distance
        int max = 0;
        int endPoint = 0;
        for (int i = 0; i < longestDistance.length; i++)
            if (longestDistance[i] > max) {
                max = longestDistance[i];
                endPoint = i;
            }
        System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n", count, startingVertex, max, endPoint);
        System.out.print("The path is: ");
        printPath(longestDistance, endPoint);
        System.out.println();
    }

    public void printPath(int[] longestDistance, int endPoint) {
        if (endPoint == startingVertex) {
            System.out.printf("%d ", startingVertex);
            return;
        }
        //find back-edge of highest length
        int nextDistance = -1;
        int next = startingVertex;
        for (int i = 1; i <= graph.size(); i++)
            if (graph.get(i).contains(endPoint) && longestDistance[i] > nextDistance) {
                nextDistance = longestDistance[i];
                next = i;
            }
        printPath(longestDistance, next);
        System.out.printf("%d ", endPoint);
    }

    //Topological sort based on depth-first search
    public void depthFirstSearch(int start) {
        discovered[start] = true;
        for (int node : graph.get(start)) {
            if (!discovered[node]) {            //if new child, add to queue
                parent[node] = start;            //remember parents, for paths
                depthFirstSearch(node);
            }
        }
        sort.push(start);
    }

    //Sparse matrix implementation of a graph
    public void insertEdge(int from, int to, boolean directed) {
        if (!graph.containsKey(from))
            graph.put(from, new TreeSet<Integer>());
        if (!graph.containsKey(to))
            graph.put(to, new TreeSet<Integer>());
        graph.get(from).add(to);
        if (!directed)
            graph.get(to).add(from);
    }

}
