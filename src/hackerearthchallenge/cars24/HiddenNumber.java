package hackerearthchallenge.cars24;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;


public class HiddenNumber {

    private static Scan inputReader = new Scan(System.in);
    private static Print output = new Print();

    public static void main(String[] args) throws IOException {

        int testCase = inputReader.readInt();

        for (int i = 0; i < testCase; i++) {
            int arrSize = inputReader.readInt();
            long arr[] = new long[arrSize];

            for (int j = 0; j < arrSize; j++) {
                arr[j] = inputReader.readInt();
            }

            long result = 0L;

            for (int k = 0; k < arrSize; k++) {
                result += arr[k];
            }
            long remainder = result % arrSize;
            result = result / arrSize;
            long ans = remainder == 0 ? result : -1;
            System.out.println(ans);
        }
        output.close();
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

