package ËÑË÷;

import java.util.Scanner;

public class ´ó³¼µÄÂÃ·Ñ_Floyd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				arr[i][j] = 999999;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = c;
			arr[b][a] = c;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i != j && arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}

				}

			}

		}
		int maxDistance = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == 999999)
					continue;
				if (arr[i][j] > maxDistance)
					maxDistance = arr[i][j];
			}
		}

		System.out.println(maxDistance * (21 + maxDistance) / 2);
	}
}
