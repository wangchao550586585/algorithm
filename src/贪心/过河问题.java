package ̰��;
import java.util.Arrays;
import java.util.Scanner;

/*
 * ����ʱȡ���ʱ�䣬��Ҫ�����͵�
 *��֤�͵ƻ��������
 *����1
	 *a[1]+a[0]+a[n]+a[1]
	 *��˼�ǣ�a1��a2���ţ�ȡa2ʱ�䣬a1�����͵ƣ�+a1ʱ�䣬a[n]��a[n-1]���ţ�ȡa[n]ʱ�䣬a[1]�����͵�
	 *�ŵ�:��Կ��С���ã���ȴ��û�ã����ָ����a[n]��a[n-1]��ʱ���,��Ϊȡ�������ʱ�䣬
 *����2
	 *	a[n]+a[0]+a[n-1]+a[n],
	 *��˼�ǣ�ÿ��a[0]�������Ĺ��ţ�Ȼ����Ի����͵ơ�
	 *�ŵ㣺��Կ�ȴ����ã����С�ģ����ֲ���ʱ����Խ��
 *����ע�⣬���������4�˼��������
 *4�����£�ͳһ����Ϊ
 *1:a[0]
 *2:a[1]
 *3:a[2]+a[1]+a[3]||a[3]+a[1]+a[2]
 *	��˼Ϊ��1��2ȥ��1�أ�1��3ȥ
 *		1��3ȥ��1�أ�1��2ȥ��ʱ��һ����������˼��һ��
 */
public class �������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			int arr[] = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			/*	if (m == 1) {
					System.out.println(arr[0]);
					continue;
				} else if (m == 2) {
					System.out.println(arr[1]);
					continue;
				} else if (m == 3) {
					System.out.println(arr[0] + arr[1] + arr[2]);
					continue;
				} else {*/
			int j = m - 1;
			int result = 0;
			while (m >= 4) {
				result += Math.min(arr[j] + arr[0] + arr[j - 1] + arr[0],
						arr[1] + arr[0] + arr[j] + arr[1]);
				m -= 2;
				j -= 2;// �������
			}
			// ����һ����m�϶�������4�˵ģ���������Ϊ2||3
			if (m == 1) {
				result = arr[0];
			} else if (m == 2) {
				result += arr[1];
			} else {
				result += arr[0] + arr[1] + arr[2];
			}
			System.out.println(result);
			// }
		}
	}
}
