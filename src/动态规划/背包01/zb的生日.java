package ��̬�滮.����01;
import java.util.Scanner;
/*
 * �����ѵ�����֮����С
 * ����ת����һ���������ܴﵽ��������Ϊ���٣�ת��Ϊ01�������⣬��������Ϻ�sum-half-half��Ϊ��
 */
public class zb������ {
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
