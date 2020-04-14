package ��̬�滮.ʯ������;

import java.util.Scanner;

/*
 * �漰����������2n�ռ�ģ�⻷����
 *�����һ�����Ӻ͵ڶ������Ӻϲ�
 *��һ�����ӵ�ֵΪ1,2
 *�ڶ������ӵ�ֵΪ2,3
 *�ϲ��Ļ���Ϊ1*2*3
 *��������ֻ����1ά������ģ��,��k�Ǵ�start��ʼ��,����ֵΪarr[start]+arr[k+1]+arr[end+1]
 *��Ҫ��������1������2֮ǰ�ϲ��Ļ��ѣ�Ҳ����dp[1][1]+dp[2][2],dp[start][k]+dp[k+1][end]
 *״̬ת�Ʒ���Ϊ��
 * dp[start][end]=min(dp[start][end],arr[start]* arr[k + 1] * arr[end + 1] + dp[start][k]+ dp[k + 1][end])
 */
public class �������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int arr[] = new int[2 * (n + 1)];
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				arr[i + n] = arr[i];
			}
			int dp[][] = new int[2 * (n + 1)][2 * (n + 1)];
			for (int len = 2; len <= n; len++) {
				for (int start = 1; start <= 2 * n - len + 1; start++) {
					int end = start + len - 1;
					for (int k = start; k < end; k++) {
						dp[start][end] = Math.max(dp[start][end], arr[start]
								* arr[k + 1] * arr[end + 1] + dp[start][k]
								+ dp[k + 1][end]);
					}
				}
			}
			// ��ҪѰ�����ֵ����Ϊ�ϲ����������
			int result = 0;
			for (int i = 1; i <= n; i++) {
				if (dp[i][i + n - 1] > result)
					result = dp[i][i + n - 1];
			}
			System.out.println(result);

		}
	}
}
