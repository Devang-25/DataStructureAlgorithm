package hackerearthchallenge.capillary;

import helperutil.Print;
import helperutil.Scan;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class DQuery {

    private static Scan scanner = new Scan(System.in);
    private static Print printer = new Print();

    private static int[] count = new int[1111111];
    private static int ans = 0;
    private static int a[];

    private static void add(int p) {
        count[a[p]]++;
        if (count[a[p]] == 1)
            ans++;
    }

    private static void remove(int p) {
        if (count[a[p]] > 0) {
            count[a[p]]--;
            if (count[a[p]] == 0)
                ans--;
        }
    }

    private static void soln() throws IOException {
        int n = scanner.readInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.readInt();
        }
        int q = scanner.readInt();
        Query[] qu = new Query[q];
        for (int i = 0; i < q; i++) {
            qu[i] = new Query(i, scanner.readInt() - 1, scanner.readInt() - 1);
        }
        Arrays.sort(qu, new Comparator<Query>() {
            public int compare(Query q1, Query q2) {
                if ((int) (q1.l / Math.sqrt(n)) == (int) (q2.l / Math.sqrt(n)))
                    return q1.r - q2.r;
                else
                    return (int) (q1.l / Math.sqrt(n) - q2.l / Math.sqrt(n));
            }
        });

        int curL = 0;
        int curR = qu[0].l;
        for (int i = 0; i < q; i++) {

            while (curL < qu[i].l) {
                remove(curL);
                curL++;
            }

            while (curL > qu[i].l) {
                add(curL - 1);
                curL--;
            }

            while (curR <= qu[i].r) {
                add(curR);
                curR++;
            }

            while (curR > qu[i].r + 1) {
                remove(curR - 1);
                curR--;
            }

            qu[i].an = ans;
        }

        Arrays.sort(qu, new Comparator<Query>() {
            public int compare(Query q1, Query q2) {
                return q1.ind - q2.ind;
            }
        });

        for (int i = 0; i < q; i++) {
            printer.println(qu[i].an);
        }

    }

    public static void main(String[] args) throws IOException {
        soln();
    }

    private static class Query {
        int ind, l, r, an;

        Query(int a, int b, int c) {
            ind = a;
            l = b;
            r = c;
            an = 0;
        }
    }
}
