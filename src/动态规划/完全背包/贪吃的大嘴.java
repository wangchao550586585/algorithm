package 动态规划.完全背包;
import java.util.Arrays;
import java.util.Scanner;

public class 贪吃的大嘴 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d;
		int count;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, 20001);
		dp[0] = 0;
		for (int i = 0; i < m; i++) {
			d = sc.nextInt();
			count = sc.nextInt();
			for (int j = 0; j < count; j++) {//这里从0开始到count-1，个数实际上相当于count
				for (int k = n; k >= d; k--) {
					dp[k] = Math.min(dp[k], dp[k - d] + 1);
				}

			}
		}

		System.out.println(dp[n] <= 50 ? dp[n] : "><");

	}
}
