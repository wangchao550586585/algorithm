package ̰��;

import java.util.Scanner;

/*
 * ˼����ÿ�η������ڵ�����Ӳ��
 * �����������ص�����
 * ���ǣ�̰�ģ���̬�滮
 * �߱������ӽṹ(�ֲ����Ž��ܵõ�ȫ�����Ž�)������̰��
 * 
 */
public class ��Ӳ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int result = f(s1, s2);
		System.out.println(result);
	}

	private static int f(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		int result = 0;
		for (int i = 0; i < a1.length - 1; i++) {
			if (a1[i] != a2[i]) {
				a1[i] = a1[i] == 'o' ? '*' : 'o';
				a1[i + 1] = a1[i + 1] == 'o' ? '*' : 'o';
				result++;
			}

		}
		return result;
	}

}
