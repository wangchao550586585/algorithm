package 搜索;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*问题描述
 给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
 输入格式
 输入的第一行为一个整数n，表示棋盘的大小。
 接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
 输出格式
 输出一个整数，表示总共有多少种放法。
 样例输入
 4
 1 1 1 1
 1 1 1 1
 1 1 1 1
 1 1 1 1
 样例输出
 2
 样例输入
 4
 1 0 1 1
 1 1 1 1
 1 1 1 1
 1 1 1 1
 样例输出

 总结:分黑白2种皇后讨论。放过皇后的位置和为0的位置不能再放皇后
 0*/
public class 二N皇后 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static int arr[][] = new int[9][9];
	static int a[] = new int[9];
	static int n;
	static int result = 0;
	static boolean flag = false;

	private static int readInt() throws IOException {
		int i, sum = 0;
		while (((i = br.read()) & 48) != 48 || i > 57)
			;
		for (; (i & 56) == 48 || (i & 62) == 56; i = br.read())
			sum = sum * 10 + (i & 15);
		return sum;

	}

	public static void main(String[] args) throws IOException {
		n = readInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = readInt();
			}
		}
		operaction(1);
		System.out.println(result);
	}

	private static void operaction(int row) {
		if (row > n && !flag) {
			flag = true;
			operaction(1);
			flag = false;
		} else if (row > n && flag) {
			result++;
		} else
			for (int i = 1; i <= n; i++) {
				if (arr[row][i] == 1) {
					int temp = a[row];
					a[row] = i;
					if (check(row)) {
						arr[row][i] = 0;
						operaction(row + 1);
						arr[row][i] = 1;
					}
					a[row] = temp;
				}
			}

	}

	private static boolean check(int row) {
		for (int i = 1; i < row; i++)
			if (Math.abs(row - i) == Math.abs(a[row] - a[i]) || a[i] == a[row])
				return false;
		return true;

	}

	private static void display() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
