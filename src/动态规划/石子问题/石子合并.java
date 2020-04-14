package 动态规划.石子问题;

import java.util.Scanner;

/*因为可以从任意点开始合并，所以无法像<还是回文数>一样，每次往后移动一位，直到结束。
 * 可以和左右2边合并
 * 阶段：2-N，每次合并长度,
 * 状态：以长度为基准，有多少个状态(可以合并多少次)，譬如长度为2，状态即为n-1
 * 决策：长度为2时，即1个决策，为3时2个决策
 * 状态转移方程:表示，合并ij的花费
 * dp[i][j]=min(dp[i][j],dp[i][k]+dp[k+1][j]+sum[i,k];
 * 2维时，只能左右合并，
 * 当3维时，可以范围合并
 * 
 * 利用切点优化
 * 第一次计算的时候会发生类似
 * dp[1][2]=dp[1][2]+dp[2][2]的事，但是肯定dp[1][2]最小，所以无需担心，到了后面的话，保证在i~j二点之间的最优值中间
 */
public class 石子合并 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int arr[] = new int[n + 1];
			int sum[] = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				sum[i] = sum[i - 1] + arr[i];
			}
			int dp[][] = new int[n + 2][n + 2];
			int point[][] = new int[n + 2][n + 2];
			for (int i = 1; i <= n; i++) {
				point[i][i] = i;
			}
			for (int len = 2; len <= n; len++) {
				for (int start = 1; start <= n - len + 1; start++) {
					int end = start + len - 1;
					dp[start][end] = 99999999;
					int startToEnd = sum[end] - sum[start - 1];
					for (int k = point[start][end - 1]; k <= point[start + 1][end]; k++) {
						if (dp[start][end] > dp[start][k] + dp[k + 1][end]
								+ startToEnd) {
							dp[start][end] = dp[start][k] + dp[k + 1][end]
									+ startToEnd;
							point[start][end] = k;// 记录最优切点
						}
					}
					// 上述为优化版
					// for (int k = start; k <= end - 1; k++) {
					// dp[start][end] = Math.min(dp[start][end], dp[start][k]
					// + dp[k + 1][end] + startToEnd);
					// }
				}
			}
			System.out.println(dp[1][n]);

		}
	}
}
