package 动态规划;
import java.util.Scanner;

/*
 * 2个字符串可以任何地方开头，所以就有2状态
 * 1：相同
 * 		dp[i][j]=dp[i-1][j-1]+1
 * 2：不相同
 * 		dp[i][j]=max(dp[i-1][j],dp[i][j-1])
 */
public class 最长公共子序列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			char[] s1 = sc.next().toCharArray();
			char[] s2 = sc.next().toCharArray();
			int dp[][] = new int[s1.length + 1][s2.length + 1];
			for (int i = 1; i <= s1.length; i++) {
				for (int j = 1; j <= s2.length; j++) {
					if (s1[i - 1] == s2[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
			System.out.println(dp[s1.length][s2.length]);

		}
	}
}
