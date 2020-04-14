package 动态规划.数塔;

import java.util.Scanner;

/*
 * 如果有学生在相邻的两层之间要停下, 则其中的一部分学生必须选择走楼梯来代替。
 * dp[n]表示从1层到n层花费的最小体力
 * 情况1:n和n-2层停，
 * 		dp[n]=dp[n-2]+n-1层的总人数*(上楼的花费||下楼的花费)
 * 情况2：n和n-3停
 * 		1:n-1层的总人数下1层，n-2层的总人数下2层
 * 		2:n-1层的总人数上2层，n-2层的总人数上1层
 * 		3:n-1层的总人数上2层，n-2层的总人数下2层
 * 		4:n-1层的总人数下1层，n-2层的总人数上1层
 *  */
public class 诡异的电梯 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int num = 1;
		while (k-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int down = sc.nextInt();
			int up = sc.nextInt();
			int arr[] = new int[100001];// 因为要上的楼层可能>n
			for (int i = 0; i < m; i++) {
				arr[sc.nextInt()]++;
			}

			//
			int dp[] = new int[100001];// 有毒，这里也不能直接设置为n
			/*
			 * 电梯从1层开始，2层开始后才可以停止，
			 * 电梯2楼停止的话，花费为0
			 * 3楼停止的话，只能算2楼的花费(选择上or下最小花费即可)
			 */
			int min = Math.min(down, up);// 优化
			dp[3] = arr[2] * min;// 3楼停止的花费
			int temp = 0;
			for (int i = 4; i <= n; i++) {// 去掉2均可
				dp[i] = dp[i - 2] + arr[i - 1] * min;
				temp = Math.min(arr[i - 1] * 2 * up + arr[i - 2] * up,
						arr[i - 1] * down + arr[i - 2] * 2 * down);
				temp = Math.min(temp, arr[i - 1] * 2 * up + arr[i - 2] * 2
						* down);
				temp = Math.min(temp, arr[i - 1] * down + arr[i - 2] * up);
				dp[i] = Math.min(dp[i], temp + dp[i - 3]);

			}
			System.out.println("Case " + (num++) + ": " + dp[n]);
		}
	}
}
