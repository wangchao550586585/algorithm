package ��̬�滮.��ȫ����;
import java.util.Arrays;
import java.util.Scanner;

public class ̰�ԵĴ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d;
		int count;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, 20001);
		dp[0] = 0;
		for (int i = 0; i < m; i++) {
			d = sc.nextInt();
			count = sc.nextInt();
			for (int j = 0; j < count; j++) {//�����0��ʼ��count-1������ʵ�����൱��count
				for (int k = n; k >= d; k--) {
					dp[k] = Math.min(dp[k], dp[k - d] + 1);
				}

			}
		}

		System.out.println(dp[n] <= 50 ? dp[n] : "><");

	}
}
