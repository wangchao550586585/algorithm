package 搜索;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 黑色外涂黑
 * 0外面的涂0
 */
public class 图像有用区域_撞墙法 {
	static int x[] = { 1, 0, -1, 0 };
	static int y[] = { 0, 1, 0, -1 };
	static int w;
	static int h;
	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			w = sc.nextInt();
			h = sc.nextInt();
			arr = new int[h + 2][w + 2];
			int i, j;
			for (i = 1; i <= h; i++) {
				for (j = 1; j <= w; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 撞墙法,四周涂1
			for (i = 0; i < w + 2; i++) {
				arr[0][i] = 1;
				arr[h + 1][i] = 1;
			}
			for (j = 1; j < h + 1; j++) {
				arr[j][0] = 1;
				arr[j][w + 1] = 1;
			}
			bfs();
			for (i = 1; i <= h; i++) {
				for (j = 1; j <= w; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { 0, 0 });
		arr[0][0] = 0;
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			for (int i = 0; i < 4; i++) {
				int xx = poll[0] + x[i];
				int yy = poll[1] + y[i];
				if (!check(xx, yy)) {
					arr[xx][yy] = 0;
					que.add(new int[] { xx, yy });
				}

			}

		}

	}

	private static boolean check(int xx, int yy) {
		return xx < 0 || xx >= h + 2 || yy < 0 || yy >= w + 2
				|| arr[xx][yy] == 0;
	}
}
