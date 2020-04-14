package ����;
import java.util.Scanner;

/*
 * ��ɫ��Ϳ��
 * 0�����Ϳ0
 */
public class ͼ����������1 {
	static int w;
	static int h;
	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			w = sc.nextInt();
			h = sc.nextInt();
			arr = new int[h][w];
			int i, j;
			for (i = 0; i < h; i++) {
				for (j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			operation();
			for (i = 0; i < h; i++) {
				for (j = 0; j < w; j++) {
					if (arr[i][j] <= 0)
						System.out.print(0 + " ");
					else
						System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void operation() {

		int i, j;
		// ���г���,ΪʲôҪ�÷�-1�ˣ��������Ϊ0�Ļ���������б�����ʱ��������0��ֹ��,�͵��½������
		for (i = 0; i < h; i++) {
			for (j = 0; j < w; j++) {
				if (arr[i][j] == 0)
					break;
				arr[i][j] = -1;
			}
		}

		for (i = 0; i < h; i++) {
			for (j = w - 1; j >= 0; j--) {
				if (arr[i][j] == 0)
					break;
				arr[i][j] = -1;
			}
		}

		// ���г���
		for (j = 0; j < w; j++) {
			for (i = 0; i < h; i++) {
				if (arr[i][j] == 0)
					break;
				arr[i][j] = -1;
			}
		}//����Ҫ�����һ�п�ʼ��ɨ����
		for (j = w - 1; j >= 0; j--) {
			for (i = h - 1; i >= 0; i--) {
				if (arr[i][j] == 0)
					break;
				arr[i][j] = -1;
			}
		}
	}

}
