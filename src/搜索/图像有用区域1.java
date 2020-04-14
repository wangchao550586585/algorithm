package 搜索;
import java.util.Scanner;

/*
 * 黑色外涂黑
 * 0外面的涂0
 */
public class 图像有用区域1 {
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
		// 从行出发,为什么要用非-1了，如果更改为0的话，下面的列遍历的时候遇到了0截止了,就导致结果错误
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

		// 从列出发
		for (j = 0; j < w; j++) {
			for (i = 0; i < h; i++) {
				if (arr[i][j] == 0)
					break;
				arr[i][j] = -1;
			}
		}//这里要从最后一行开始，扫描列
		for (j = w - 1; j >= 0; j--) {
			for (i = h - 1; i >= 0; i--) {
				if (arr[i][j] == 0)
					break;
				arr[i][j] = -1;
			}
		}
	}

}
