package ��̬�滮.����ֶκ�;
import java.util.Scanner;

/*
 * ����ʯ�����⣬����ģ�⻷
 * ViС��0��ʱ�򣬱�ʾ������������ʳ�ġ�
 * ֻ�ܰ�һ�Σ������ܹ���������һ�ε�ʳ�ġ�
 * ��Ϊ���������һ�Σ�������ֶκ�
 * ��ʽ1������ÿһ���ڵ㣬
 * ��ʽ2����������ֶκͣ�
 * 		��������С�ֶκ�
 * 		��ֵ-���С�ֶκͣ���Ϊ���ε���ֶκ�
 * 		2�߱Ƚϣ�ȡ��󼴿�
 */
public class ���ϵ�����2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();

			/*O(n)^2
			 * int arr[] = new int[2 * (n + 1)];
			 * for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				arr[i + n] = arr[i];
			}
			int resuls = 0;
			for (int i = 1; i <= n; i++) {
				int temp = 0;
				for (int j = i; j < i + n; j++) {
					temp += arr[j];
					if (temp > resuls)
						resuls = temp;
					if (temp < 0)
						temp = 0;
				}
			}*/

			// O(N)
			int temp = 0;
			int temp1 = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int num = 0;
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				num = sc.nextInt();
				sum += num;
				temp += num;
				temp1 += num;
				max = max < temp ? temp : max;
				min = min > temp1 ? temp1 : min;
				if (temp < 0)
					temp = 0;
				if (temp1 > 0)
					temp1 = 0;
			}
			int max2 = sum - min;
			int result = max > max2 ? max : max2;
			System.out.println(result);
		}
	}
}
