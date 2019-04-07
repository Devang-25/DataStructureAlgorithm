package hackerearthchallenge.wissen;

import java.util.*;

public class DirectoryDeletion {
    private static Map<Integer, Integer> intMap = new HashMap<>();
    private static int ans = 0;
    private int vt;
    private LinkedList<Integer> adjList[];

    DirectoryDeletion(int vt) {
        this.vt = vt;
        adjList = new LinkedList[vt];
        for (int i = 0; i < vt; ++i) {
            adjList[i] = new LinkedList();
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DirectoryDeletion directoryDeletion = new DirectoryDeletion(n + 1);
        // Ignore root node id
        scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            directoryDeletion.insertEdge(scanner.nextInt(), i);
        }
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            intMap.put(scanner.nextInt(), 1);
        }

        directoryDeletion.dfsSearch(1);
        System.out.println(ans);
    }

    private void insertEdge(int vt, int wt) {
        adjList[vt].add(wt);
    }

    private void dfsUtil(int vt, boolean vst[]) {
        vst[vt] = true;
        if (intMap.containsKey(vt)) {
            ans++;
            return;
        }
        Iterator<Integer> it = adjList[vt].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!vst[n])
                dfsUtil(n, vst);
        }
    }

    private void dfsSearch(int vt) {
        boolean visited[] = new boolean[this.vt];
        dfsUtil(vt, visited);
    }
}

