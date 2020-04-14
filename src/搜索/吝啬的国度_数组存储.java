package 搜索;
import java.util.Scanner;
/*
 * 采用数组存储，类似深搜。效率优
 */
public class 吝啬的国度_数组存储 {

	static int result[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			int s = sc.nextInt();
			result = new int[m + 1];
			int i, j, a, b;
			for (i = 0; i < m - 1; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				if (result[a] != 0) {
					update(b);
					result[b] = a;
				} else {
					result[a] = b;
				}
			}
			update(s);
			result[s] = -1;
			for (i = 1; i <= m; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}

	private static void update(int b) {
		int i = result[b];
		if (i != 0) {//注意这里是if
			update(i);
			result[i] = b;
		}
	}
}
