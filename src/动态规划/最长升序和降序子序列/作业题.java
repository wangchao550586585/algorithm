package 动态规划.最长升序和降序子序列;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 作业题 {
	static class Position {
		public int x;
		public int y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			Position p[] = new Position[m];
			for (int i = 0; i < m; i++) {
				p[i] = new Position(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(p, new Comparator<Position>() {
				public int compare(Position o1, Position o2) {
					return o1.x - o2.x;
				}
			});
			int dpUp[] = new int[m + 1];
			int dpDown[] = new int[m + 1];
			for (int i = 0; i <= m; i++) {//这里忘记了索引是从0开始的
				dpDown[i] = 1;
				dpUp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (i == m || p[i].y >= p[j].y) {
						dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
					}
					if (i == m || p[i].y <= p[j].y) {
						dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
					}
				}
			}
			System.out.println(Math.max(dpDown[m], dpUp[m]) - 1);
		}
	}
}
