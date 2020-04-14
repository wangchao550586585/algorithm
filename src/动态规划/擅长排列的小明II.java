package 动态规划;
import java.util.Scanner;

/*
 * 第一个数为1
 * 2数之差<=2
 * 第一个数为1
 * 		那么第二个数就可以为
 * 				2，后面可以任意(n-1)
 * 				3后面能4/5/2
 * 					当为4时，下一个数为2，下一个数为5，不满足条件，
 * 					当为5时，下一个可以为4，下一个可以为2，特殊的组合13542
 * 					当为2时，下一个只能为4，下一个可以任意，n-3
 * dp[n]=dp[n-1]+dp[n-3]+1;
 * 					
 */
public class 擅长排列的小明II {
	public static void main(String[] args) {
		int dp[] = new int[56];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 4;
		for (int i = 5; i <= 55; i++) {
			dp[i] = dp[i - 1] + dp[i - 3] + 1;
		}
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			System.out.println(dp[m]);
		}
	}
}
