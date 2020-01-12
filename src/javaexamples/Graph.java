package javaexamples;

import java.util.*;

public class Graph {
     static int center;
     static int maxLen;
     static List<Integer> node = new ArrayList<>(10);

     LinkedList<Integer> adj[];

    Graph(int vert) {
        adj = new LinkedList[vert + 1];
        for (int i = 0; i <= vert; i++)
            adj[i] = new LinkedList();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        int u, v;
        for (int i = 0; i < test; i++) {
            center = 0;
            maxLen = 0;
            node = new ArrayList<>();
            int n = s.nextInt();
            boolean visited[] = new boolean[n + 1];
            Graph g = new Graph(n);
            for (int j = 0; j < n-1; j++) {
                u = s.nextInt();
                v = s.nextInt();
                g.addEdge(u, v);
            }
            g.DFSUtil(1, visited);
            System.out.println(center + " " + (maxLen - 1) / 2);
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        node.add(v);
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
        if (node.size() == maxLen && node.get((node.size() - 1) / 2) < center)
            center = node.get((node.size() - 1) / 2);
        else if (node.size() > maxLen) {
            maxLen = node.size();
            center = node.get((node.size() - 1) / 2);
        }
        node.remove(node.size() / 2);
    }
}


