

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ∂¡»°∑Ω Ω2 {
	static class Reader14 {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		static void init() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = new StringTokenizer("");
		}

		static String next() throws IOException {
			while (!tokenizer.hasMoreElements()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) throws IOException {
		Reader14.init();
		int n = Reader14.nextInt();
		int m = Reader14.nextInt();
		int arr[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Reader14.nextInt();
				arr[i][j] += Math.max(arr[i - 1][j], arr[i][j - 1]);
			}
		}
		System.out.println(arr[n][m]);
	}
}
