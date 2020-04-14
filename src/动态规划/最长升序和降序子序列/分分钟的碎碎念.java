package 动态规划.最长升序和降序子序列;

import java.util.Scanner;

public class 分分钟的碎碎念 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		// method:1，新建一个数组存储值
		/*int dp[] = new int[n + 1];
				for (int i = 1; i <= n; i++) {
					dp[i] = 1;
					if (arr[i] != 0) {
						dp[i] = dp[arr[i]] + 1;
					}}
		System.out.println(Arrays.toString(dp));
				*/
		// method:2,无需新建数组，因为第一个数开头总是0，直接累计加即可
		int result = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[arr[i]] + 1;
			result = Math.max(arr[i], result);
		}
		System.out.println(result);
	}
}
