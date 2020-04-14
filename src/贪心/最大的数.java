package ̰��;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����������Ϊ��1�ĺ���ӣ���Ϊÿ�������Ժ�����2�ߵ������мӣ�����������Ҫ�ľ��Ǻ���ʹ1�ӵ�ֵ�������������
 * ����3�ľ�����ӣ��ܱ�֤�˻����
 * ��Ϊ1��n-1ֻ��1�ߣ����е����ó�������
 * ��һ��Ϊ1���ӵ��ڶ�λ�ü���
 * ��n-1λΪ1���ӵ��������ķ�0����
 * ʣ�µ���2~n-2��Χ
 * ��Ϊ����3�����Ϊ2*1<3
 * ������������������2ֱ�Ӽӣ�����2�Ŀ��ܴ���2��Ҳ����С��2�����><2�ģ�������ӣ����������ߣ���Ϊ�ұ�δ֪��
 * ����������Ϊ0����ô��ߵ�����-1���Ƶ�ǰ���Ǹ����ϣ���Ϊ��Χn��������a[i]��1<=a[i]<=20�������б�֤ʹ���ֵ���,Ҳ�������ȿ�����ߵ�ֵ,
 * ��������̰�ġ�
 * 
 * 
 */
public class ������ {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		InputStreamReader isr = new InputStreamReader(bis);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while ((str = br.readLine()) != null) {
			int n = Integer.parseInt(str);
			String s[] = br.readLine().split(" ");
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			// ����߽�
			if (n > 1 && arr[0] == 1) {
				arr[1] += 1;
				arr[0] = 0;
			}

			for (int i = 1; i < n - 1; i++) {
				if (arr[i] == 1) {
					arr[i] = 0;
					add(arr, i - 1, i + 1);
				}
			}
			// ����߽�
			if (n > 1 && arr[n - 1] == 1) {
				int index = n - 2;
				while (index >= 0 && arr[index] == 0)
					index--;
				arr[index] += 1;
				arr[n - 1] = 0;
			}
			long result = 1;
			for (int i = 0; i < n; i++) {
				if (arr[i] != 0)
					result = result * arr[i] % 10086;
				;
			}
			System.out.println(result);
		}
	}

	private static void add(int[] arr, int i, int j) {
		//��ʵ֤��������3�ľ������ӵĳ˻����,2*1<3
		if (arr[i] == 2) {
			arr[i]++;
			return;
		}
		if (arr[i] == 0)//���Ϊ0˵����ߵ�ֵ�ӵ����ұ�
			i--;
		//2�߾���
		if (arr[i] <= arr[j]) {
			arr[i]++;
		} else {
			arr[j]++;
		}  
//		arr[i]<=arr[j]?arr[i]++:arr[j]++; c/C++֧��

	}
}
