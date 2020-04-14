package 动态规划.区间;
import java.util.Scanner;

/*
 * 长度为N的字符串，变成回文数的花费
 * 如果是要一维数组的话dp[]不行
 * 因为有可能删除中间的字符，有可能删除最后一个字符，删除的字符所在的区间不确定所以采用二维数组
 * dp[i][j]:表示i~j范围内的花费，最后的花费必然是dp[1][n]
 * 1:首先只保留对某个字符的最小花费
 * 2： 删除或者增加i,j位置的字符,dp[i][j]=min(dp[i+1][j]+arr[i],dp[i][j-1]+arr[j)
 * 		  当arr[i]=arr[j]就多出现一种情况，dp[i-1][j-1]
 * abcd举例
 * 首先确定dp[1][2]的花费
 * 然后在确定dp[1][3]的花费，确定1~3的花费，就需要确定1~2和2~3的花费，因为1~2已经求出，接下来求2~3,------->后往前推
 * 1~4，因为1~3已经求出，接下来需要求出2~4，2~3已经求出，就只需要求出3~4的花费
 * 当1==4的时候，就出现一种情况,这种情况添加2~3的值就行了
 */
public class 还是回文 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[] s = sc.next().toCharArray();
			int arr[] = new int[26];
			for (int i = 0; i < n; i++) {
				arr[sc.next().charAt(0) - 'a'] = Math.min(sc.nextInt(),
						sc.nextInt());
			}

			int dp[][] = new int[m][m];
			for (int i = 1; i < m; i++) {
				for (int j = i - 1; j >= 0; j--) {
					dp[j][i] = Math.min(dp[j + 1][i] + arr[s[j] - 'a'],
							dp[j][i - 1] + arr[s[i] - 'a']);
					if (s[i] == s[j]) {
						dp[j][i] = Math.min(dp[j][i], dp[j + 1][i - 1]);
					}
				}
			}

			System.out.println(dp[0][m - 1]);
		}
	}
}
