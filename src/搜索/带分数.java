package 搜索;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 带分数

时间限制：1.0s   内存限制：256.0MB

问题描述
100 可以表示为带分数的形式：100 = 3 + 69258 / 714。

还可以表示为：100 = 82 + 3546 / 197。

注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
  
类似这样的带分数，100 有 11 种表示法。

输入格式
从标准输入读入一个正整数N (N<1000*1000)

输出格式
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。

注意：不要求输出每个表示，只统计有多少表示法！

样例输入1
100
样例输出1
11
样例输入2
105
样例输出2
6
 */
public class 带分数 {
	static boolean flag[];
	static int v;
	static int length;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i < n; i++) {
			flag = new boolean[10];
			flag[0] = true;
			if (check(i))
				continue;
			v = n - i;
			dfs(0, 0);
		}
		System.out.println(result);
	}

	private static void dfs(int num, int count) {
		if (count <= length / 2) {
			if (check1(num * v) == length - count) {
				result++;
			}
			for (int i = 1; i < 10; i++) {
				if (flag[i])
					continue;
				flag[i] = true;
				dfs(num * 10 + i, count + 1);
				flag[i] = false;
			}
		}
	}

	private static int check1(int num) {
		boolean[] flag1 = Arrays.copyOf(flag, flag.length);
		int count = 0;
		while (num != 0) {
			int a = num % 10;
			if (flag1[a])
				return -1;
			flag1[a] = true;
			num = num / 10;
			count++;
		}
		return count;
	}

	private static boolean check(int num) {
		int count = 0;
		while (num != 0) {
			int a = num % 10;
			if (flag[a])
				return true;
			flag[a] = true;
			num = num / 10;
			count++;
		}
		length = 9 - count;
		return false;
	}
}