package helperutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Scan {
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

    public final String readString() throws IOException {
        int c = scan();
        while (isWhiteSpace(c)) {
            c = scan();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.append((char) c);
            c = scan();
        } while (!isWhiteSpace(c));
        return res.toString();
    }

    public final long readLong() throws IOException {
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
        long res = 0;
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

    public final char readChar() throws IOException {
        int c = scan();
        while (isWhiteSpace(c)) {
            c = scan();
        }
        return (char) c;
    }
}