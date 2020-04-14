package 动态规划.背包01;
import java.util.Scanner;

public class 苹果 {
	static class Apple {
		public int c;
		public int w;

		public Apple(int c, int w) {
			this.c = c;
			this.w = w;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int v = sc.nextInt();
			if (n == 0 && v == 0)
				break;
			Apple[] apple = new Apple[n];
			for (int i = 0; i < n; i++) {
				apple[i] = new Apple(sc.nextInt(), sc.nextInt());
			}
			int[] dp = new int[v + 1];
			for (int i = 0; i < n; i++) {
				for (int j = v; j >= apple[i].c; j--) {
					dp[j] = Math.max(dp[j], dp[j - apple[i].c] + apple[i].w);
				}
			}
			System.out.println(dp[v]);

		}
	}

}
