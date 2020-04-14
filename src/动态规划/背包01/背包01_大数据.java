package 动态规划.背包01;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 重量w，放满N个物品保证价值最大，
 * 当w过小时可以使用dp[w]=max(dp[w],dp[w-j]+vi);j表示重量，vi表示当前价格
 * 当w过大时，不适用
 * 可以使用问题转换，价值p，保证放满重量最少的物品。
 * dp[p]=min(dp[p],dp[p-j]+w);j表示价格，w表示当前价格的重量
 * 然后查找出比w小的dp[p]最大价值
 * 返回dp对应的索引即是答案
 */
public class 背包01_大数据 {
	private static final int INF = 2 << 29;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int w = sc.nextInt();
			int wi[] = new int[n];
			int vi[] = new int[n];
			int sumPrice = 0;
			for (int i = 0; i < n; i++) {
				wi[i] = sc.nextInt();
				vi[i] = sc.nextInt();
				sumPrice += vi[i];
			}
			long dp[] = new long[sumPrice + 1];
			Arrays.fill(dp, INF);
			dp[0] = 0;//一定要初始化为0，不然会无法计算。这样他才能在0的基础上不停递增
			for (int i = 0; i < n; i++) {
				for (int j = sumPrice; j >= vi[i]; j--) {
					dp[j] = Math.min(dp[j], dp[j - vi[i]] + wi[i]);
				}
			}
			long result = 0;
			for (int i = 0; i <= sumPrice; i++) {
				if (dp[i] <= w) {
					result = i;
				}
			}
			System.out.println(result);

		}
	}
}
