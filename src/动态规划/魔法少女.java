package ��̬�滮;
import java.util.Scanner;

public class ħ����Ů {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int arr[] = new int[m + 2];
			for (int i = 1; i <= m; i++)
				arr[i] = sc.nextInt();
			int dp[] = new int[m + 2];
			dp[1] = arr[1];
			dp[2] = arr[2];
			dp[3] = arr[3];
			for (int i = 4; i <= m + 1; i++) {//¥����߲㣬������ǰ��ķɹ�ȥ������M+1�㼴��
				dp[i] = min(dp[i - 1], dp[i - 2], dp[i - 3]) + arr[i];
			}
			System.out.println(dp[m+1]);
		}
	}

	private static int min(int i, int j, int k) {
		return i > j ? (j > k ? k : j) : (i > k ? k : i);
	}
}
