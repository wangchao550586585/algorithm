package 动态规划;

import java.util.Scanner;

/*
 * 0->(0,1)
 * 1->(0)
 *	dp[n]=dp[n-1]以0结尾*2+dp[n-1]以1结尾
 *提取共性，以1结尾的下一个数只能是0，以0结尾的能0，1，
 *dp[n]以0结尾的为dp[n-1]
 *接下来解决dp[n]以1结尾，以1结尾的，前一个必定为0，问题转化为求dp[n-1]0结尾的个数，
 *而dp[n-1]以0结尾的个数我们已经证明出为dp[n-2]
 *dp[n]=dp[n-1]+dp[n-2]
 */
public class Zero_One串 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			int dp[] = new int[m + 1];
			dp[1] = 2;
			dp[2] = 3;
			// dp[3] = 5;//添加会出错，-_-'
			for (int i = 3; i <= m; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			System.out.println(dp[m]);

		}
	}
}
