package 动态规划.最长升序和降序子序列;

import java.util.Scanner;

/*升序
 * 它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能超过前一发的高度。要准备几套这样的导弹拦截系统
 * 能有多少个最长降序子序列==>最长升序子序列长度
 * 因为降序只能覆盖降序的，升序的绝对覆盖不了，实际上求得就是升序的个数
 */
public class 导弹拦截2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		while ((m = sc.nextInt()) != -1) {
			int arr[] = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = sc.nextInt();
			int[] dp = new int[m + 1];

			for (int i = 1; i <= m; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (i == m || arr[i] >= arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
			System.out.println(dp[m] - 1);
		}
	}
}
