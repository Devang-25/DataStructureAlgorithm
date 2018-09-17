package hackerearthchallenge.rapido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrizeMoney {

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int N = fastReader.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = fastReader.nextInt();
		}
		int minD = getMax(arr);
		for (int i = (minD+1); i < 1000000000; i++) {
			int num =  getNum(i, arr);
			if (num != 0) {
				System.out.println(num); 
				return;
			}
		}
		System.out.println("Fake Offer!");
	}

	private static int getNum(int i, int[] arr) {
			for (int j = 0; j < arr.length; j++) {
				 i = i % arr[j];
			} 
			if (i == 0) {
				return 0;
			}else {
				return i;
			}
	}

	private static int getMax(int[] arr) {
		int min=arr[0];
        for(int ii=1;ii<arr.length;ii++){
            if(arr[ii]>min){
                min=arr[ii];
            }
        }
		return min;
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
