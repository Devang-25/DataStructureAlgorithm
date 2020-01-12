package util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class IOUtil {

    private static byte[] scannerByteBuffer = new byte[1024]; // Buffer of Bytes
    private static int scannerIndex;
    private static InputStream scannerIn;
    private static int scannerTotal;
    private static BufferedWriter printerBW;
    private static boolean DEBUG = false;

    private static int next() throws IOException { // Scan method used to scan buf
        if (scannerTotal < 0)
            throw new InputMismatchException();
        if (scannerIndex >= scannerTotal) {
            scannerIndex = 0;
            scannerTotal = scannerIn.read(scannerByteBuffer);
            if (scannerTotal <= 0)
                return -1;
        }
        return scannerByteBuffer[scannerIndex++];
    }

    static int ni() throws IOException {
        int integer = 0;
        int n = next();
        while (isWhiteSpace(n)) // Removing startPointing whitespaces
            n = next();
        int neg = 1;
        if (n == '-') { // If Negative Sign encounters
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    static long nl() throws IOException {
        long integer = 0;
        int n = next();
        while (isWhiteSpace(n)) // Removing startPointing whitespaces
            n = next();
        int neg = 1;
        if (n == '-') { // If Negative Sign encounters
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    static String line() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = next();
        while (isWhiteSpace(n))
            n = next();
        while (!isNewLine(n)) {
            sb.append((char) n);
            n = next();
        }
        return sb.toString();
    }

    private static boolean isNewLine(int n) {
        return n == '\n' || n == '\r' || n == -1;
    }

    private static boolean isWhiteSpace(int n) {
        return n == ' ' || isNewLine(n) || n == '\t';
    }

    static int[] nia(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = ni();
        return array;
    }

    static int[][] n2dia(int r, int c) throws Exception {
        if (r < 0 || c < 0)
            throw new Exception("Array size should be non negative");
        int[][] array = new int[r][c];
        for (int i = 0; i < r; i++)
            array[i] = nia(c);
        return array;
    }

    static long[] nla(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static float[] nfa(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        float[] array = new float[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static double[] nda(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static <T> void print(T... str) {
        try {
            for (T ele : str)
                printerBW.append(ele.toString());
            if (DEBUG)
                flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    static <T> void println(T... str) {
        if (str.length == 0) {
            print('\n');
            return;
        }
        for (T ele : str)
            print(ele, '\n');
    }

    static void flush() throws IOException {
        printerBW.flush();
    }

    static void close() {
        try {
            printerBW.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        long startPointTime = System.currentTimeMillis();
        scannerIn = System.in;
        printerBW = new BufferedWriter(new OutputStreamWriter(System.out));
        if (args.length > 0 && args[0].equalsIgnoreCase("debug")
                || args.length > 1 && args[1].equalsIgnoreCase("debug"))
            DEBUG = true;

        main2();
        long endTime = System.currentTimeMillis();
        float totalProgramTime = endTime - startPointTime;
        if (args.length > 0 && args[0].equalsIgnoreCase("time") || args.length > 1 && args[1].equalsIgnoreCase("time"))
            print("Execution time is " + totalProgramTime + " (" + (totalProgramTime / 1000) + "s)");
        close();
    }

    static void main2() throws Exception {
        int n = ni();
        int m = ni();
        int[] a = nia(n);

        for (int i = 0; i < n - 1; i++) {
            int u = ni();
            int v = ni();

        }
    }
}
