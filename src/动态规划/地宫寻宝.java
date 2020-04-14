package 动态规划;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.management.MXBean;

public class 地宫寻宝 {
	private static final long MOD = 1000000007;
	static BufferedInputStream bi = new BufferedInputStream(System.in);

	private static int readInt() throws IOException {
		int sum = 0;
		int i = 0;
		while (((i = bi.read()) & 48) != 48 || i > 57) {
		}
		for (; (i & 56) == 48 || (i & 62) == 56; i = bi.read())
			sum = sum * 10 + (i & 15);
		return sum;

	}

	static int arr[][];
	static long[][][][] minutes;
	static int n;
	static int m;
	static int k;
	static int x[] = { 0, 1 };
	static int y[] = { 1, 0 };

	public static void main(String[] args) throws IOException {
		init();
		long result = dfs(0, 0, -1, 0);
		System.out.println(result);
	}

	private static long dfs(int row, int col, int maxPrice, int count) {
		if (minutes[row][col][maxPrice + 1][count] != -1)
			return minutes[row][col][maxPrice + 1][count];
		if (row == n - 1 && col == m - 1) {
			if (count == k || count + 1 == k && maxPrice < arr[row][col]) {
				return minutes[row][col][maxPrice + 1][count] = 1;
			}
			return minutes[row][col][maxPrice + 1][count] = 0;
		}
		long result = 0;
		for (int i = 0; i < 2; i++) {
			int xx = row + x[i];
			int yy = col + y[i];
			if (xx >= n || yy >= m)
				continue;
			if (maxPrice < arr[row][col]) {
				result = (result + dfs(xx, yy, arr[row][col], count + 1)) % MOD;
			}
			result = (result + dfs(xx, yy, maxPrice, count)) % MOD;

		}

		// if (row + 1 < n) {
		// if (arr[row][col] > maxPrice) {
		// result = (result + dfs(row + 1, col, arr[row][col], count + 1))
		// % MOD;
		// }
		// result = (result + dfs(row + 1, col, maxPrice, count)) % MOD;
		// }
		// if (col + 1 < m) {
		// if (arr[row][col] > maxPrice) {
		// result = (result + dfs(row, col + 1, arr[row][col], count + 1))
		// % MOD;
		// }
		// result = (result + dfs(row, col + 1, maxPrice, count)) % MOD;
		// }
		minutes[row][col][maxPrice + 1][count] = result;
		return result;
	}

	private static void init() throws IOException {
		n = readInt();
		m = readInt();
		k = readInt();
		arr = new int[n][m];
		minutes = new long[n][m][14][13];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int a = 0; a < 14; a++) {
					for (int b = 0; b < 13; b++) {
						minutes[i][j][a][b] = -1;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = readInt();
			}
		}
	}
}
