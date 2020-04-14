package ��̬�滮.����;

import java.util.Scanner;

/*
 * �����ѧ�������ڵ�����֮��Ҫͣ��, �����е�һ����ѧ������ѡ����¥�������档
 * dp[n]��ʾ��1�㵽n�㻨�ѵ���С����
 * ���1:n��n-2��ͣ��
 * 		dp[n]=dp[n-2]+n-1���������*(��¥�Ļ���||��¥�Ļ���)
 * ���2��n��n-3ͣ
 * 		1:n-1�����������1�㣬n-2�����������2��
 * 		2:n-1�����������2�㣬n-2�����������1��
 * 		3:n-1�����������2�㣬n-2�����������2��
 * 		4:n-1�����������1�㣬n-2�����������1��
 *  */
public class ����ĵ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int num = 1;
		while (k-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int down = sc.nextInt();
			int up = sc.nextInt();
			int arr[] = new int[100001];// ��ΪҪ�ϵ�¥�����>n
			for (int i = 0; i < m; i++) {
				arr[sc.nextInt()]++;
			}

			//
			int dp[] = new int[100001];// �ж�������Ҳ����ֱ������Ϊn
			/*
			 * ���ݴ�1�㿪ʼ��2�㿪ʼ��ſ���ֹͣ��
			 * ����2¥ֹͣ�Ļ�������Ϊ0
			 * 3¥ֹͣ�Ļ���ֻ����2¥�Ļ���(ѡ����or����С���Ѽ���)
			 */
			int min = Math.min(down, up);// �Ż�
			dp[3] = arr[2] * min;// 3¥ֹͣ�Ļ���
			int temp = 0;
			for (int i = 4; i <= n; i++) {// ȥ��2����
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
