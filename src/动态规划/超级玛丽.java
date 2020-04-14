package 动态规划;
import java.util.Scanner;

/*
 * 陷阱不会位于1及n上
 * 没有陷阱时:
 * 			dp[n]=dp[n-1]+dp[n-2];
 * 有陷阱的时：
 * 			点1是陷阱的话，只会影响1后面的，
 * 			如果点1是陷阱的话，点2为dp[2]=dp[2-2]加上之前那个点即可
 * 也就是陷阱那个点不参与运算
 */
public class 超级玛丽 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean flag[] = new boolean[n + 1];
		int temp = 0;
		for (int i = 0; i < m; i++) {
			temp = sc.nextInt();
			if (temp < n)//测试数据>=N，日狗
				flag[temp] = true;
		}
		int dp[] = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (flag[i])
				continue;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}
}
