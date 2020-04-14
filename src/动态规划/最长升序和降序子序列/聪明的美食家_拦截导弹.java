package 动态规划.最长升序和降序子序列;

import java.util.Scanner;

/*升序
 * 定义一个范围，为n，然后，让n与之前的所有数进行比较，当遇到比自己小的值时候，拿他+1与自己比较,取最大值即可
 * dp[n]=max(dp[n],dp[n-k]+1);
 * 
 * 
 * if (i == n || arr[i] < arr[j])利用此，优化找寻最大值
 * 优化初始化dp数组
 */
public class 聪明的美食家_拦截导弹 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int dp[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				//升序
				if (i == n || arr[i] >= arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				//降序,如导弹拦截1
				/*if (i == n || arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}*/
			}
		}
		System.out.println(dp[n] - 1);

	}
}
