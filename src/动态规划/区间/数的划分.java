package 动态规划.区间;

import java.util.Scanner;

public class 数的划分 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int dp[][] = new int[num + 1][num + 1];
		for (int i = 0; i <= num; i++) {
			dp[i][1] = 1;
			dp[i][i] = 1;
		}
		for (int i = 3; i <= num; i++) {
			for (int j = 2; j < num; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j];
			}
		}
		int result = 0;
		for (int i = 1; i <= num; i++)
			result += dp[num][i];
		System.out.println(result);

	}

}
