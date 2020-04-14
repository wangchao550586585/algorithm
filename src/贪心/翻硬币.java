package 贪心;

import java.util.Scanner;

/*
 * 思考：每次翻动相邻的两个硬币
 * 具有子问题重叠问题
 * 考虑，贪心，动态规划
 * 具备最优子结构(局部最优解能得到全局最优解)，考虑贪心
 * 
 */
public class 翻硬币 {
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
