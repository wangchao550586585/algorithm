package ̰��;
import java.util.Scanner;

public class �׳�֮�� {
	static int ss[] = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			for (int i = 9; i > 0; i--) {
				if (m >= ss[i]) {
					m -= ss[i];
				} /*else  ���ܽ�����Ҫ���������
					break;*/
			}
			System.out.println(m == 0 ? "Yes" : "No");
		}
	}
}
