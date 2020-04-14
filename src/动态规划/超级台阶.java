package 动态规划;
import java.util.Scanner;

public class 超级台阶 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			int dp[] = new int[41];// 台阶可能<3，所以直接最大容量
			dp[1] = 0;// 规定从一级到一级有0种走法,也就是从第一层开始
			dp[2] = 1;
			dp[3] = 2;
			for (int i = 4; i <= m; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			System.out.println(dp[m]);
		}

	}
}
