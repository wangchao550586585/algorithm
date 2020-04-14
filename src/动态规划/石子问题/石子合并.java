package ��̬�滮.ʯ������;

import java.util.Scanner;

/*��Ϊ���Դ�����㿪ʼ�ϲ��������޷���<���ǻ�����>һ����ÿ�������ƶ�һλ��ֱ��������
 * ���Ժ�����2�ߺϲ�
 * �׶Σ�2-N��ÿ�κϲ�����,
 * ״̬���Գ���Ϊ��׼���ж��ٸ�״̬(���Ժϲ����ٴ�)��Ʃ�糤��Ϊ2��״̬��Ϊn-1
 * ���ߣ�����Ϊ2ʱ����1�����ߣ�Ϊ3ʱ2������
 * ״̬ת�Ʒ���:��ʾ���ϲ�ij�Ļ���
 * dp[i][j]=min(dp[i][j],dp[i][k]+dp[k+1][j]+sum[i,k];
 * 2άʱ��ֻ�����Һϲ���
 * ��3άʱ�����Է�Χ�ϲ�
 * 
 * �����е��Ż�
 * ��һ�μ����ʱ��ᷢ������
 * dp[1][2]=dp[1][2]+dp[2][2]���£����ǿ϶�dp[1][2]��С���������赣�ģ����˺���Ļ�����֤��i~j����֮�������ֵ�м�
 */
public class ʯ�Ӻϲ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int arr[] = new int[n + 1];
			int sum[] = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				sum[i] = sum[i - 1] + arr[i];
			}
			int dp[][] = new int[n + 2][n + 2];
			int point[][] = new int[n + 2][n + 2];
			for (int i = 1; i <= n; i++) {
				point[i][i] = i;
			}
			for (int len = 2; len <= n; len++) {
				for (int start = 1; start <= n - len + 1; start++) {
					int end = start + len - 1;
					dp[start][end] = 99999999;
					int startToEnd = sum[end] - sum[start - 1];
					for (int k = point[start][end - 1]; k <= point[start + 1][end]; k++) {
						if (dp[start][end] > dp[start][k] + dp[k + 1][end]
								+ startToEnd) {
							dp[start][end] = dp[start][k] + dp[k + 1][end]
									+ startToEnd;
							point[start][end] = k;// ��¼�����е�
						}
					}
					// ����Ϊ�Ż���
					// for (int k = start; k <= end - 1; k++) {
					// dp[start][end] = Math.min(dp[start][end], dp[start][k]
					// + dp[k + 1][end] + startToEnd);
					// }
				}
			}
			System.out.println(dp[1][n]);

		}
	}
}
