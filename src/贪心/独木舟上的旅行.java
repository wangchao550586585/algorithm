package ̰��;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ����Ȼ���Ҵ����,�Ҳ�����ĵ������ӣ��ҵĵ���ģ��ʹ���ӡ�
 */
public class ��ľ���ϵ����� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int w = sc.nextInt();
			int m = sc.nextInt();
			int arr[] = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			int count = 0;
			for (int i = 0, j = m - 1; i <= j;) {// ��Ž����ʱ��˵��ֻʣ��һ�����ˡ�
				if (arr[i] + arr[j] <= w) {// �ҵõ���Ļ�
					i++;
					j--;
					count++;
				} else {// �Ҳ�����Ļ�
					j--;
					count++;
				}
			}
			System.out.println(count);

		}
	}
}
