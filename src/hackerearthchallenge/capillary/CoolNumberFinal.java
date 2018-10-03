package hackerearthchallenge.capillary;

import helperutil.Print;
import helperutil.Scan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Capillary Java Hiring Challenge
 *
 * https://www.hackerearth.com/problem/algorithm/cool-numbers-19/
 */
public class CoolNumberFinal {

	private static Scan scanner = new Scan(System.in);
	private static Print printer = new Print();

	public static void main(String args[]) throws Exception {
		init();
		process();
		printer.close();
	}

	private static List<Long> cool = new ArrayList<>();

	private static void init() {
		List<Long> temp = new ArrayList<Long>();
		List<Long> next = new ArrayList<Long>();
		temp.add(2l);
		temp.add(5l);
		for (int i = 0; i < 9; i++) {
			cool.addAll(temp);
			for (long d : temp) {
				next.add(d * 10 + 2);
				next.add(d * 10 + 5);
			}
			temp.clear();
			temp.addAll(next);
			next.clear();
		}
		cool.add(2222222222l);
		cool.add(2222222225l);
		Collections.sort(cool);
	}


	public static void process() throws IOException {
		int t = scanner.readInt();
		for (int i1 = 0; i1 < t; i1++) {
			long n = scanner.readInt();
			long m = scanner.readInt();
			long res = 0, curr = 0;
			int idx = 0;
			while (cool.get(idx) < n)
				idx++;

			curr = cool.get(idx);

			while (n <= m) {
				long toAdd = curr - n + 1;
				if (curr > m) {
					toAdd = m - n + 1;
				}
				res += (toAdd * curr);
				n = curr + 1;
				idx++;
				curr = cool.get(idx);
			}
			printer.println(res);
		}
	}
}
