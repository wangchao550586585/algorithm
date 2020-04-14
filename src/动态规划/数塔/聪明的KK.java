package 动态规划.数塔;
import java.util.Scanner;

/*
 * 数塔：从某一点转向另一点或者说是从某一状态转向另一状态，有多种选择方式（比如这里的9->12 , 9->15），从中选取一条能产生最优值的路径。
 * 从(1,1)出发(n,m)点吃最多的虫子,可以向右边以及下边走，
 * 第二层依赖上层和左边
 * (n,m)依赖(n-1,m)||(m,n-1)二点。选择最大即可+
 */
public class 聪明的KK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
				arr[i][j] += Math.max(arr[i - 1][j], arr[i][j - 1]);
			}
		}
		System.out.println(arr[n][m]);
	}
}
