package ��̬�滮;

import java.util.Scanner;

/*
 * 0->(0,1)
 * 1->(0)
 *	dp[n]=dp[n-1]��0��β*2+dp[n-1]��1��β
 *��ȡ���ԣ���1��β����һ����ֻ����0����0��β����0��1��
 *dp[n]��0��β��Ϊdp[n-1]
 *���������dp[n]��1��β����1��β�ģ�ǰһ���ض�Ϊ0������ת��Ϊ��dp[n-1]0��β�ĸ�����
 *��dp[n-1]��0��β�ĸ��������Ѿ�֤����Ϊdp[n-2]
 *dp[n]=dp[n-1]+dp[n-2]
 */
public class Zero_One�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			int dp[] = new int[m + 1];
			dp[1] = 2;
			dp[2] = 3;
			// dp[3] = 5;//��ӻ����-_-'
			for (int i = 3; i <= m; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			System.out.println(dp[m]);

		}
	}
}
