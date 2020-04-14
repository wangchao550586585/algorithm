package ����;

import java.util.Arrays;
import java.util.Scanner;
/*
 * ������

ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB

��������
100 ���Ա�ʾΪ����������ʽ��100 = 3 + 69258 / 714��

�����Ա�ʾΪ��100 = 82 + 3546 / 197��

ע���������������У�����1~9�ֱ������ֻ����һ�Σ�������0����
  
���������Ĵ�������100 �� 11 �ֱ�ʾ����

�����ʽ
�ӱ�׼�������һ��������N (N<1000*1000)

�����ʽ
�������������������1~9���ظ�����©����ɴ�������ʾ��ȫ��������

ע�⣺��Ҫ�����ÿ����ʾ��ֻͳ���ж��ٱ�ʾ����

��������1
100
�������1
11
��������2
105
�������2
6
 */
public class ������ {
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