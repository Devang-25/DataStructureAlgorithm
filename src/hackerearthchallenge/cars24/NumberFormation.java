package hackerearthchallenge.cars24;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class NumberFormation {

    private static Scan scanner = new Scan(System.in);
    private static Print printer = new Print();
    private static final int MODULO = 720720;

    public static void main(String[] args) throws IOException {

        int arrSize = scanner.readInt();
        int arr[] = new int[arrSize];
        int count = 0;

        for(int i=0;i<arrSize;i++){
            int data = scanner.readInt();
            if(data != 0){
                count++;
            }
            arr[i] = data;
        }

        int k = scanner.readInt();
        int ans = getPossibleSubsequence(count, arrSize);
        System.out.println(ans);

        printer.close();
    }

    private static int getPossibleSubsequence(int count, int arrSize) {

        return 0;
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

    static class Print {

        private final BufferedWriter bw;

        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}
