package ËÑË÷;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class °Ë»Êºó {
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static int arr[][] = new int[9][9];
	static int a[] = new int[9];
	static int n;
	static int result = 0;

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
		if (row > n) {
			result++;
			display();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (arr[row][i] == 1) {
				int temp = a[row];
				a[row] = i;
				if (check(row)) {
					arr[row][i] = 2;
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
