package ��̬�滮;
import java.util.Scanner;

public class ����̨�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			int dp[] = new int[41];// ̨�׿���<3������ֱ���������
			dp[1] = 0;// �涨��һ����һ����0���߷�,Ҳ���Ǵӵ�һ�㿪ʼ
			dp[2] = 1;
			dp[3] = 2;
			for (int i = 4; i <= m; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			System.out.println(dp[m]);
		}

	}
}
