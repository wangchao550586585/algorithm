package ��̬�滮.����ֶκ�;
import java.util.Scanner;

public class ����ֶκ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while (k-- > 0) {
			int n = sc.nextInt();
			int result = -1;
			int temp = 0;
			for (int i = 0; i < n; i++) {
				temp += sc.nextInt();
				if (temp > result) {
					result = temp;
				}
				if (temp < 0)
					temp = 0;
			}
			System.out.println(result);
		}

	}
}
