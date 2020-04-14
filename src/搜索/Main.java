package ËÑË÷;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] flag;
	static int v, ls, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 1; i < num; i++) {
			flag = new boolean[10];
			flag[0] = true;
			if (check(i)) {
				v = num - i;
				dfs(0, 0);
			}
		}
		System.out.println(result);
		sc.close();
	}

	private static void dfs(int length, int num) {
		if (length <= ls / 2) {
			if (judge(v * num) == ls - length)
				result++;
			for (int i = 1; i < 10; i++) {
				if (flag[i])
					continue;
				flag[i] = true;
				dfs(length + 1, num * 10 + i);
				flag[i] = false;
			}
		}

	}

	private static int judge(int n) {
		boolean[] flag1 = Arrays.copyOf(flag, flag.length);
		int size = 0;
		while (n != 0) {
			int r = n % 10;
			if (flag1[r])
				return -1;
			flag1[r] = true;
			n /= 10;
			size++;
		}
		return size;
	}

	private static boolean check(int n) {
		int size = 0;
		while (n != 0) {
			int r = n % 10;
			if (flag[r])
				return false;
			flag[r] = true;
			n /= 10;
			size++;
		}
		ls = 9 - size;
		return true;
	}
}