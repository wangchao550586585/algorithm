package ̰��;
import java.util.Arrays;
import java.util.Scanner;

/*
 * ʵ���������Բ�İ뾶�Ƿ���ڳ����ε�б�Խ���(Ҳ���������ε�б��,double d = Math.sqrt(20 * 20 + 1) / 2)��
 * �����а뾶Ϊheight/2Ҳ���ǰ뾶Ϊ1��Բ����Ϊ��֤���㹻����ˮװ�ã����������������ʡ��
 * 
 */
public class ��ˮװ��1 {
	public static void main(String[] args) {
		double d = Math.sqrt(20 * 20 + 1) / 2;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			double[] arr = new double[m];
			int index = 0;
			for (int i = 0; i < m; i++) {
				double k = sc.nextDouble();
				if (k != 1)
					arr[index++] = k;

			}
			Arrays.sort(arr, 0, index);
			double sum = 0;
			int i = index - 1;
			for (; i >= 0; i--) {
				sum += arr[i];
				if (sum > d) {
					break;
				}
			}
			System.out.println(index - i);

		}
	}
}
