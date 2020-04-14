package 动态规划.完全背包;

import java.util.Scanner;
/*
 * 针对有小数，不便使用
 */
public class 背包问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int s = sc.nextInt();
			int m = sc.nextInt();
			int dp[] = new int[m + 1];
			for (int i = 0; i < s; i++) {
				int v = sc.nextInt();
				int w = sc.nextInt();
				// 完全背包转换为01背包,拆分，购买多次
				for (int k = 1; k <= w; k++)
					for (int j = m; j > 0; j--) {
						dp[j] = Math.max(dp[j], dp[j - 1] + v);
					}
			}
			System.out.println(dp[m]);
		}
	}
}
