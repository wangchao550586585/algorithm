package ��̬�滮.�����ͽ���������;

import java.util.Scanner;

/*����
 * ����һ����Χ��Ϊn��Ȼ����n��֮ǰ�����������бȽϣ����������Լ�С��ֵʱ������+1���Լ��Ƚ�,ȡ���ֵ����
 * dp[n]=max(dp[n],dp[n-k]+1);
 * 
 * 
 * if (i == n || arr[i] < arr[j])���ôˣ��Ż���Ѱ���ֵ
 * �Ż���ʼ��dp����
 */
public class ��������ʳ��_���ص��� {
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
				//����
				if (i == n || arr[i] >= arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				//����,�絼������1
				/*if (i == n || arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}*/
			}
		}
		System.out.println(dp[n] - 1);

	}
}
