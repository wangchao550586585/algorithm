package 动态规划.背包01;
import java.util.Scanner;

public class 背包01_小数据 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; i++) {
			int wi = sc.nextInt();
			int vi = sc.nextInt();
			for (int j = m; j >= wi; j--) {
				dp[j] = Math.max(dp[j], dp[j - wi] + vi);
			}
		}
		System.out.println(dp[m]);
	}
}
