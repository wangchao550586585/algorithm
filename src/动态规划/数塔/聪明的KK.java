package ��̬�滮.����;
import java.util.Scanner;

/*
 * ��������ĳһ��ת����һ�����˵�Ǵ�ĳһ״̬ת����һ״̬���ж���ѡ��ʽ�����������9->12 , 9->15��������ѡȡһ���ܲ�������ֵ��·����
 * ��(1,1)����(n,m)������ĳ���,�������ұ��Լ��±��ߣ�
 * �ڶ��������ϲ�����
 * (n,m)����(n-1,m)||(m,n-1)���㡣ѡ����󼴿�+
 */
public class ������KK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
				arr[i][j] += Math.max(arr[i - 1][j], arr[i][j - 1]);
			}
		}
		System.out.println(arr[n][m]);
	}
}
