package ��̬�滮;
import java.util.Scanner;

/*
 * ���岻��λ��1��n��
 * û������ʱ:
 * 			dp[n]=dp[n-1]+dp[n-2];
 * �������ʱ��
 * 			��1������Ļ���ֻ��Ӱ��1����ģ�
 * 			�����1������Ļ�����2Ϊdp[2]=dp[2-2]����֮ǰ�Ǹ��㼴��
 * Ҳ���������Ǹ��㲻��������
 */
public class �������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean flag[] = new boolean[n + 1];
		int temp = 0;
		for (int i = 0; i < m; i++) {
			temp = sc.nextInt();
			if (temp < n)//��������>=N���չ�
				flag[temp] = true;
		}
		int dp[] = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (flag[i])
				continue;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}
}
