package ��̬�滮.�����ͽ���������;

import java.util.Scanner;

public class �ַ��ӵ������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		// method:1���½�һ������洢ֵ
		/*int dp[] = new int[n + 1];
				for (int i = 1; i <= n; i++) {
					dp[i] = 1;
					if (arr[i] != 0) {
						dp[i] = dp[arr[i]] + 1;
					}}
		System.out.println(Arrays.toString(dp));
				*/
		// method:2,�����½����飬��Ϊ��һ������ͷ����0��ֱ���ۼƼӼ���
		int result = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[arr[i]] + 1;
			result = Math.max(arr[i], result);
		}
		System.out.println(result);
	}
}
