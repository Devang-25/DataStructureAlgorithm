package codechef.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class EATTWICE {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            String s[] = bf.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int[] D = new int[N];
            int[] V = new int[N];

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] st = bf.readLine().split(" ");
                D[i] = Integer.parseInt(st[0]);
                V[i] = Integer.parseInt(st[1]);

                if (map.containsKey(D[i])) {
                    int oldVal = map.get(D[i]);
                    if (oldVal < V[i]) {
                        map.put(D[i], V[i]);
                    }
                } else {
                    map.put(D[i], V[i]);
                }
            }

            int key[] = new int[map.size()];
            int val[] = new int[map.size()];
            int i = 0, max = Integer.MIN_VALUE;
            int maxIndex = -1;
            int ans = 0;
            for (Map.Entry mapElement : map.entrySet()) {
                key[i] = (int) mapElement.getKey();
                val[i] = (int) mapElement.getValue();
                if (max < val[i]) {
                    max = val[i];
                    maxIndex = i;
                }
                i++;
            }

            int first = key[maxIndex];
            M = M - key[maxIndex];
            ans += val[maxIndex];
            val[maxIndex] = Integer.MIN_VALUE;
            max = Integer.MIN_VALUE;
            for (int j = 0; j < val.length; j++) {
                if (val[j] > max && key[j] != first) {
                    max = val[j];
                    maxIndex = j;
                }
            }
            ans += val[maxIndex];
            System.out.println(ans);
        }
    }
}
