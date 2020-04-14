package 动态规划.数塔;
import java.util.Scanner;

/*
 * 如果使用第一秒的获取第二秒最多的，当到第二秒时，又是以第二秒为状态去获取下一秒的最多的，第一秒获得的无法获得。
 * 建模。
 * 他是从下往上的获取馅饼个数，直至获得最多，
 * 如果从下面往上获得的话取最大值相加的话，无法存储之前的状态
 * 从下面往下面获得的话，最终会靠近左边或者右边的最大值，也无法保存之前获得的值
 * 从上往下的话，无法保存之前的值
 * 从上往上的话，能够不停的靠近5这个点
 */
public class 免费馅饼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while ((n = sc.nextInt()) != 0) {
			int[][] s = new int[100001][13];
			int point;
			int time;
			int maxTime = 0;
			for (int i = 0; i < n; i++) {
				point = sc.nextInt();
				time = sc.nextInt();
				s[time][point + 1]++;
				maxTime = Math.max(maxTime, time);
			}
			/*
			 * 这种方式无法保存之前拿到的
			 */
			/*			for (int i = 0; i < maxTime; i++) {
							for (int j = 1; j < 12; j++) {
								s[i][j] += max(s[i + 1][j], s[i + 1][j + 1], s[i + 1][j - 1]);
							}
							System.out.print(Arrays.toString(s[i]));
							System.out.println();
						}
						for (int i = 2; i <= maxTime+1; i++) {
				for (int j = 1; j < 12; j++) {
					s[i][j] += max(s[i - 1][j], s[i - 1][j + 1],
							s[i - 1][j - 1]);
				}
				System.out.print(Arrays.toString(s[i]));
				System.out.println();
			}
			for (int i = maxTime; i > 0; i++) {
				for (int j = 1; j < 12; j++) {
					s[i][j] += max(s[i - 1][j], s[i - 1][j + 1],
							s[i - 1][j - 1]);
				}
			*/
			// 此种方式最终会拿到当前的个数
			for (int i = maxTime - 1; i >= 0; i--) {
				for (int j = 1; j < 12; j++) {
					s[i][j] += max(s[i + 1][j], s[i + 1][j + 1],
							s[i + 1][j - 1]);
				}
			}
			System.out.println(s[0][6]);
		}
	}

	private static int max(int i, int j, int k) {
		return i > j ? (i > k ? i : k) : (j > k ? j : k);
	}
}
