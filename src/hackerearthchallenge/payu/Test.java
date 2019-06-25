package hackerearthchallenge.payu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Test {

    static int minEdgeBFS(Vector<Integer> edges[],
                          int u,
                          int v, int n) {
        Vector<Boolean> visited = new Vector<>(n);

        for (int i = 0; i < n; i++) {
            visited.addElement(false);
        }

        Vector<Integer> distance = new Vector<>(n);

        for (int i = 0; i < n; i++) {
            distance.addElement(0);
        }

        Queue<Integer> Q = new LinkedList<>();
        distance.setElementAt(0, u);

        Q.add(u);
        visited.setElementAt(true, u);
        while (!Q.isEmpty()) {
            int x = Q.peek();
            Q.poll();

            for (int i = 0; i < edges[x].size(); i++) {
                if (visited.elementAt(edges[x].get(i)))
                    continue;

                distance.setElementAt(distance.get(x) + 1,
                        edges[x].get(i));
                Q.add(edges[x].get(i));
                visited.setElementAt(true, edges[x].get(i));
            }
        }
        return distance.get(v);
    }

    static void addEdge(Vector<Integer> edges[],
                        int u, int v) {
        edges[u].add(v);
        edges[v].add(u);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int Q = scanner.nextInt();
        int arr[] = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            arr[i] = scanner.nextInt();
        }

        Vector<Integer> edges[] = new Vector[vertex+1];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Vector<>();
        }
        for (int i = 0; i < (vertex - 1); i++) {
            addEdge(edges, scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < Q; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int num = minEdgeBFS(edges, u, v, vertex+1);
            if (num % 2 == 0)
                System.out.println("Bob");
            else
                System.out.println("Alex");
        }
    }
}