package ��̬�滮.�����ͽ���������;
import java.util.Scanner;

/*����
 * ʱ�临�Ӷ�O(log)
 * ��arr����ÿ���ó�һ��������t���������Ϊ���бȽϣ�
 * 			�󣺷�t�������
 * 			С�����Ǵ�t������ǰ�����һ�����Լ�С�ģ�������ǰ��һ��,(����2�ֲ���)
 * 				t[1]<t<t[2],����t2
 */
public class ��������2_�Ż� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		while ((m = sc.nextInt()) != -1) {
			int arr[] = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = sc.nextInt();
			int t[] = new int[m];
			t[0] = arr[0];
			int index = 0;
			for (int i = 1; i < m; i++) {
				if (arr[i] > t[index]) {
					t[++index] = arr[i];
				} else {
					int in = search(arr[i], t, index);
					t[in] = arr[i];
				}
			}
			System.out.println(index + 1);

		}
	}

	private static int search(int num, int[] t, int len) {
		int start = 0;
		int end = len;
		while (start < end) {
			int mid = (start + end) / 2;
			if (t[mid] >= num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
