package ��̬�滮.����;
import java.util.Scanner;

/*
 * ���ʹ�õ�һ��Ļ�ȡ�ڶ������ģ������ڶ���ʱ�������Եڶ���Ϊ״̬ȥ��ȡ��һ������ģ���һ���õ��޷���á�
 * ��ģ��
 * ���Ǵ������ϵĻ�ȡ�ڱ�������ֱ�������࣬
 * ������������ϻ�õĻ�ȡ���ֵ��ӵĻ����޷��洢֮ǰ��״̬
 * �������������õĻ������ջ῿����߻����ұߵ����ֵ��Ҳ�޷�����֮ǰ��õ�ֵ
 * �������µĻ����޷�����֮ǰ��ֵ
 * �������ϵĻ����ܹ���ͣ�Ŀ���5�����
 */
public class ����ڱ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while ((n = sc.nextInt()) != 0) {
			int[][] s = new int[100001][13];
			int point;
			int time;
			int maxTime = 0;
			for (int i = 0; i < n; i++) {
				point = sc.nextInt();
				time = sc.nextInt();
				s[time][point + 1]++;
				maxTime = Math.max(maxTime, time);
			}
			/*
			 * ���ַ�ʽ�޷�����֮ǰ�õ���
			 */
			/*			for (int i = 0; i < maxTime; i++) {
							for (int j = 1; j < 12; j++) {
								s[i][j] += max(s[i + 1][j], s[i + 1][j + 1], s[i + 1][j - 1]);
							}
							System.out.print(Arrays.toString(s[i]));
							System.out.println();
						}
						for (int i = 2; i <= maxTime+1; i++) {
				for (int j = 1; j < 12; j++) {
					s[i][j] += max(s[i - 1][j], s[i - 1][j + 1],
							s[i - 1][j - 1]);
				}
				System.out.print(Arrays.toString(s[i]));
				System.out.println();
			}
			for (int i = maxTime; i > 0; i++) {
				for (int j = 1; j < 12; j++) {
					s[i][j] += max(s[i - 1][j], s[i - 1][j + 1],
							s[i - 1][j - 1]);
				}
			*/
			// ���ַ�ʽ���ջ��õ���ǰ�ĸ���
			for (int i = maxTime - 1; i >= 0; i--) {
				for (int j = 1; j < 12; j++) {
					s[i][j] += max(s[i + 1][j], s[i + 1][j + 1],
							s[i + 1][j - 1]);
				}
			}
			System.out.println(s[0][6]);
		}
	}

	private static int max(int i, int j, int k) {
		return i > j ? (i > k ? i : k) : (j > k ? j : k);
	}
}
