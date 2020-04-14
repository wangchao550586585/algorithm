package ��̬�滮.����;
import java.util.Scanner;

/*
 * ����ΪN���ַ�������ɻ������Ļ���
 * �����Ҫһά����Ļ�dp[]����
 * ��Ϊ�п���ɾ���м���ַ����п���ɾ�����һ���ַ���ɾ�����ַ����ڵ����䲻ȷ�����Բ��ö�ά����
 * dp[i][j]:��ʾi~j��Χ�ڵĻ��ѣ����Ļ��ѱ�Ȼ��dp[1][n]
 * 1:����ֻ������ĳ���ַ�����С����
 * 2�� ɾ����������i,jλ�õ��ַ�,dp[i][j]=min(dp[i+1][j]+arr[i],dp[i][j-1]+arr[j)
 * 		  ��arr[i]=arr[j]�Ͷ����һ�������dp[i-1][j-1]
 * abcd����
 * ����ȷ��dp[1][2]�Ļ���
 * Ȼ����ȷ��dp[1][3]�Ļ��ѣ�ȷ��1~3�Ļ��ѣ�����Ҫȷ��1~2��2~3�Ļ��ѣ���Ϊ1~2�Ѿ��������������2~3,------->����ǰ��
 * 1~4����Ϊ1~3�Ѿ��������������Ҫ���2~4��2~3�Ѿ��������ֻ��Ҫ���3~4�Ļ���
 * ��1==4��ʱ�򣬾ͳ���һ�����,����������2~3��ֵ������
 */
public class ���ǻ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[] s = sc.next().toCharArray();
			int arr[] = new int[26];
			for (int i = 0; i < n; i++) {
				arr[sc.next().charAt(0) - 'a'] = Math.min(sc.nextInt(),
						sc.nextInt());
			}

			int dp[][] = new int[m][m];
			for (int i = 1; i < m; i++) {
				for (int j = i - 1; j >= 0; j--) {
					dp[j][i] = Math.min(dp[j + 1][i] + arr[s[j] - 'a'],
							dp[j][i - 1] + arr[s[i] - 'a']);
					if (s[i] == s[j]) {
						dp[j][i] = Math.min(dp[j][i], dp[j + 1][i - 1]);
					}
				}
			}

			System.out.println(dp[0][m - 1]);
		}
	}
}
