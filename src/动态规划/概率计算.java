package ��̬�滮;
import java.util.Scanner;

/*
 * ��������
 ����n����[a,b]�����������������ǵĺ�Ϊx�ĸ��ʡ�
 �����ʽ
 һ�������ĸ���������Ϊn��a��b��x���ÿո�ָ���
 �����ʽ
 ���һ�а���һ��С��λ��Ϊx�ĸ��ʣ�С���������λС��
 ��������
 2 1 3 4
 �������
 0.3333
 ���ݹ�ģ��Լ��
 ����50%�����ݣ�n��5.
 ����100%�����ݣ�n��100,b��100.
 ���ʣ���һ������1/2���ڶ���������1/4,
 */
public class ���ʼ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		double[][] arr = new double[n + 1][x + 1];// �������ĺ͵ĸ���
		double temp = 1.0 / (b - a + 1);
		for (int i = 1; i <= n; i++) {// ȡ���ٸ���
			for (int j = i * a; j <= i * b && j <= x; j++) {// ȡ��ֵ�÷�Χ
				if (i == 1)
					arr[i][j] = temp;
				else {
					for (int k = a; k <= b; k++) {// ����ǰһ��״̬
						if (j >= k)
							arr[i][j] += (arr[i - 1][j - k] * temp);
					}
				}

			}
		}
		System.out.printf("%.4f",arr[n][x]);
	}
}
