package hackerearthchallenge.rapido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravellingBetweenCities {

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int testCase = fastReader.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			int N = fastReader.nextInt();
			int K = fastReader.nextInt();
			int Q = fastReader.nextInt();
			
			int[] cityArr = new int[N];
			for (int j = 0; j < N; j++) {
				cityArr[j] = fastReader.nextInt(); 
			}
			
			for (int j = 0; j < Q; j++) {
				
				int minX = cityArr[fastReader.nextInt()-1];
				int maxX = cityArr[fastReader.nextInt()-1];
				int fromX = cityArr[fastReader.nextInt()-1];
				// Code here
				
				
				// Output
			}
		}
	}

	private static int getStartLocation(int[] cityArr, int x) {
		int temp = cityArr[x-1];
		for (int i = 0; i < cityArr.length; i++) {
			if (temp == cityArr[i]) {
				return i;
			} 
		}
		return 0; 
	}

	private static int getMinX(int[] cityArr, int l, int r) {
		// TODO Auto-generated method stub 
		return 0;
	}

	private static int getMaxX(int[] cityArr, int l, int r) {
		// TODO Auto-generated method stub 
		return 0;
	}

	private static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
