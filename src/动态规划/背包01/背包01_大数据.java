package ��̬�滮.����01;
import java.util.Arrays;
import java.util.Scanner;

/*
 * ����w������N����Ʒ��֤��ֵ���
 * ��w��Сʱ����ʹ��dp[w]=max(dp[w],dp[w-j]+vi);j��ʾ������vi��ʾ��ǰ�۸�
 * ��w����ʱ��������
 * ����ʹ������ת������ֵp����֤�����������ٵ���Ʒ��
 * dp[p]=min(dp[p],dp[p-j]+w);j��ʾ�۸�w��ʾ��ǰ�۸������
 * Ȼ����ҳ���wС��dp[p]����ֵ
 * ����dp��Ӧ���������Ǵ�
 */
public class ����01_������ {
	private static final int INF = 2 << 29;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int w = sc.nextInt();
			int wi[] = new int[n];
			int vi[] = new int[n];
			int sumPrice = 0;
			for (int i = 0; i < n; i++) {
				wi[i] = sc.nextInt();
				vi[i] = sc.nextInt();
				sumPrice += vi[i];
			}
			long dp[] = new long[sumPrice + 1];
			Arrays.fill(dp, INF);
			dp[0] = 0;//һ��Ҫ��ʼ��Ϊ0����Ȼ���޷����㡣������������0�Ļ����ϲ�ͣ����
			for (int i = 0; i < n; i++) {
				for (int j = sumPrice; j >= vi[i]; j--) {
					dp[j] = Math.min(dp[j], dp[j - vi[i]] + wi[i]);
				}
			}
			long result = 0;
			for (int i = 0; i <= sumPrice; i++) {
				if (dp[i] <= w) {
					result = i;
				}
			}
			System.out.println(result);

		}
	}
}
