package ����;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*��������
 ����һ��n*n�����̣���������һЩλ�ò��ܷŻʺ�����Ҫ�������з���n���ڻʺ��n���׻ʺ�ʹ����������ڻʺ󶼲���ͬһ�С�ͬһ�л�ͬһ���Խ����ϣ�����������׻ʺ󶼲���ͬһ�С�ͬһ�л�ͬһ���Խ����ϡ����ܹ��ж����ַŷ���nС�ڵ���8��
 �����ʽ
 ����ĵ�һ��Ϊһ������n����ʾ���̵Ĵ�С��
 ������n�У�ÿ��n��0��1�����������һ������Ϊ1����ʾ��Ӧ��λ�ÿ��ԷŻʺ����һ������Ϊ0����ʾ��Ӧ��λ�ò����ԷŻʺ�
 �����ʽ
 ���һ����������ʾ�ܹ��ж����ַŷ���
 ��������
 4
 1 1 1 1
 1 1 1 1
 1 1 1 1
 1 1 1 1
 �������
 2
 ��������
 4
 1 0 1 1
 1 1 1 1
 1 1 1 1
 1 1 1 1
 �������

 �ܽ�:�ֺڰ�2�ֻʺ����ۡ��Ź��ʺ��λ�ú�Ϊ0��λ�ò����ٷŻʺ�
 0*/
public class ��N�ʺ� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static int arr[][] = new int[9][9];
	static int a[] = new int[9];
	static int n;
	static int result = 0;
	static boolean flag = false;

	private static int readInt() throws IOException {
		int i, sum = 0;
		while (((i = br.read()) & 48) != 48 || i > 57)
			;
		for (; (i & 56) == 48 || (i & 62) == 56; i = br.read())
			sum = sum * 10 + (i & 15);
		return sum;

	}

	public static void main(String[] args) throws IOException {
		n = readInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = readInt();
			}
		}
		operaction(1);
		System.out.println(result);
	}

	private static void operaction(int row) {
		if (row > n && !flag) {
			flag = true;
			operaction(1);
			flag = false;
		} else if (row > n && flag) {
			result++;
		} else
			for (int i = 1; i <= n; i++) {
				if (arr[row][i] == 1) {
					int temp = a[row];
					a[row] = i;
					if (check(row)) {
						arr[row][i] = 0;
						operaction(row + 1);
						arr[row][i] = 1;
					}
					a[row] = temp;
				}
			}

	}

	private static boolean check(int row) {
		for (int i = 1; i < row; i++)
			if (Math.abs(row - i) == Math.abs(a[row] - a[i]) || a[i] == a[row])
				return false;
		return true;

	}

	private static void display() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
