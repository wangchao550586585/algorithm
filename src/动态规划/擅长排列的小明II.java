package ��̬�滮;
import java.util.Scanner;

/*
 * ��һ����Ϊ1
 * 2��֮��<=2
 * ��һ����Ϊ1
 * 		��ô�ڶ������Ϳ���Ϊ
 * 				2�������������(n-1)
 * 				3������4/5/2
 * 					��Ϊ4ʱ����һ����Ϊ2����һ����Ϊ5��������������
 * 					��Ϊ5ʱ����һ������Ϊ4����һ������Ϊ2����������13542
 * 					��Ϊ2ʱ����һ��ֻ��Ϊ4����һ���������⣬n-3
 * dp[n]=dp[n-1]+dp[n-3]+1;
 * 					
 */
public class �ó����е�С��II {
	public static void main(String[] args) {
		int dp[] = new int[56];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 4;
		for (int i = 5; i <= 55; i++) {
			dp[i] = dp[i - 1] + dp[i - 3] + 1;
		}
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			System.out.println(dp[m]);
		}
	}
}
