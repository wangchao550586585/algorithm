package 动态规划.背包01;

import java.util.Arrays;
import java.util.Scanner;

public class 硬币找零 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int m;
		while ((n = sc.nextInt()) != 0 && (m = sc.nextInt()) != 0) {
			int arr[] = new int[m + 1];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int dp[] = new int[m + 1];
			Arrays.fill(dp, 100001);
			dp[0] = 0;
			for (int i = 0; i < n; i++) {
				for (int j = arr[i]; j <= m; j++) {
					dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
				}
			}
		/*	不加也可以过 -_-^^
		 * for (int i = m; i >= 0; i--) {
				if (dp[i] > 100001) {
					System.out.println(dp[i]);
					break;
				}
			}*/
			System.out.println(dp[m]);
		}
	}
}
