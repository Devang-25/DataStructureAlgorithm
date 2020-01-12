package codechef.longchallenge.oct19b;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Queue;

public class PhonePrice {

    private static final int LAST_SIZE = 5;

    public static void main(String[] args) throws IOException {
        MinHeap minHeap = new MinHeap();
        Scan scan = new Scan(System.in);
        int t = scan.readInt();
        while (t-- > 0) {
            int n = scan.readInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.readInt();
            }

            int count = 1, size = -1;
            int currMin = arr[LAST_SIZE];
            for (int i = LAST_SIZE; i <= arr.length; i++) {
                int newMin = minHeap.getMin(arr, i);
                if (size == 5) {
                    currMin = newMin;
                    size = 0;
                }
                if (newMin < currMin) {
                    currMin = newMin;
                    count++;
                } else {
                    size++;
                }
                minHeap.pQueue.clear();
            }
            System.out.println(count);
            minHeap.pQueue.clear();
        }
    }

    static class MinHeap {
        Queue<Integer> pQueue = new PriorityQueue<>(5);

        public int getMin(int[] arr, int e) {
            for (int i = e - 5; i < e; i++) {
                pQueue.offer(arr[i]);
            }
            return pQueue.poll();
        }
    }

    static class Scan {
        private byte[] buff = new byte[1024];
        private int index;
        private InputStream inputStream;
        private int total;

        public Scan(InputStream stream) {
            inputStream = stream;
        }

        private int scan() throws IOException {
            if (total < 0)
                throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = inputStream.read(buff);
                if (total <= 0)
                    return -1;
            }
            return buff[index++];
        }

        public final int readInt() throws IOException {
            int c = scan();
            boolean neg = false;
            while (isWhiteSpace(c)) {
                c = scan();
            }
            char d = (char) c;
            if (d == '-') {
                neg = true;
                c = scan();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = scan();
            } while (!isWhiteSpace(c));
            if (neg)
                return -res;
            return res;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
                return true;
            return false;
        }
    }
}
