package 动态规划.石子问题;

import java.util.Scanner;

/*
 * 涉及到环，开辟2n空间模拟环即可
 *假设第一个珠子和第二个珠子合并
 *第一个珠子的值为1,2
 *第二个珠子的值为2,3
 *合并的花费为1*2*3
 *但是这里只用了1维数组来模拟,而k是从start开始的,所以值为arr[start]+arr[k+1]+arr[end+1]
 *还要加上珠子1和珠子2之前合并的花费，也就是dp[1][1]+dp[2][2],dp[start][k]+dp[k+1][end]
 *状态转移方程为：
 * dp[start][end]=min(dp[start][end],arr[start]* arr[k + 1] * arr[end + 1] + dp[start][k]+ dp[k + 1][end])
 */
public class 能量项链 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int arr[] = new int[2 * (n + 1)];
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				arr[i + n] = arr[i];
			}
			int dp[][] = new int[2 * (n + 1)][2 * (n + 1)];
			for (int len = 2; len <= n; len++) {
				for (int start = 1; start <= 2 * n - len + 1; start++) {
					int end = start + len - 1;
					for (int k = start; k < end; k++) {
						dp[start][end] = Math.max(dp[start][end], arr[start]
								* arr[k + 1] * arr[end + 1] + dp[start][k]
								+ dp[k + 1][end]);
					}
				}
			}
			// 还要寻找最大值，既为合并的最大能量
			int result = 0;
			for (int i = 1; i <= n; i++) {
				if (dp[i][i + n - 1] > result)
					result = dp[i][i + n - 1];
			}
			System.out.println(result);

		}
	}
}
