package ��̬�滮.�����ͽ���������;

import java.util.Scanner;

/*����
 * ���ĵ�һ���ڵ��ܹ���������ĸ߶ȣ������Ժ�ÿһ���ڵ������ܳ���ǰһ���ĸ߶ȡ�Ҫ׼�����������ĵ�������ϵͳ
 * ���ж��ٸ������������==>����������г���
 * ��Ϊ����ֻ�ܸ��ǽ���ģ�����ľ��Ը��ǲ��ˣ�ʵ������þ�������ĸ���
 */
public class ��������2 {
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
