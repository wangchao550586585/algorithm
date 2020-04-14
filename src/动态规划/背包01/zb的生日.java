package 动态规划.背包01;
import java.util.Scanner;
/*
 * 让两堆的重量之差最小
 * 问题转换，一半重量所能达到的最大组合为多少？转换为01背包问题，求出最大组合后，sum-half-half即为答案
 */
public class zb的生日 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int arr[] = new int[m];
			int sum = 0;
			for (int i = 0; i < m; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			int half = sum >> 1;
			int dp[] = new int[half + 1];
			for (int i = 0; i < m; i++) {
				for (int j = half; j >= arr[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
				}
			}
			System.out.println(sum - (dp[half] << 1));

		}
	}
}
