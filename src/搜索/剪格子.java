package ËÑË÷;

import java.util.Scanner;

public class ¼ô¸ñ×Ó {
	static int arr[][];
	static int n;
	static int m;
	static int result;
	static int x[] = { 1, 0, -1, 0 };
	static int y[] = { 0, 1, 0, -1 };
	static int half;
	static boolean[][] flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		result = n * m;
		arr = new int[n][m];
		flag = new boolean[n][m];
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				sum += arr[i][j];
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}

		half = sum / 2;
		if (half * 2 != sum || max > half) {
			System.out.println(0);
			return;
		}
		f();
	}

	private static void f() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				dfs(i, j, 1);
			}
		System.out.println(result == n * m ? 0 : result);
	}

	private static void dfs(int row, int col, int count) {
		flag[row][col] = true;
		half -= arr[row][col];
		if (half == 0) {
			int re = count;
			if (!flag[0][0]) {
				re = n * m - re;
				if (re < result)
					result = re;
			} else if (flag[0][0]) {
				if (re < result)
					result = re;
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int xx = row + x[i];
				int yy = col + y[i];
				if (check(xx, yy)) {
					continue;
				}
				dfs(xx, yy, count + 1);
			}
		}
		flag[row][col] = false;
		half += arr[row][col];

	}

	private static boolean check(int xx, int yy) {
		return xx < 0 || xx >= n || yy < 0 || yy >= m || flag[xx][yy]
				|| half - arr[xx][yy] < 0;
	}
}
