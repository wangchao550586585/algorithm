package ��̬�滮.��ȫ����;

import java.util.Scanner;
/*
 * �����С��������ʹ��
 */
public class �������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int s = sc.nextInt();
			int m = sc.nextInt();
			int dp[] = new int[m + 1];
			for (int i = 0; i < s; i++) {
				int v = sc.nextInt();
				int w = sc.nextInt();
				// ��ȫ����ת��Ϊ01����,��֣�������
				for (int k = 1; k <= w; k++)
					for (int j = m; j > 0; j--) {
						dp[j] = Math.max(dp[j], dp[j - 1] + v);
					}
			}
			System.out.println(dp[m]);
		}
	}
}
