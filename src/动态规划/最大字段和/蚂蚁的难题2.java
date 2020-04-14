package 动态规划.最大字段和;
import java.util.Scanner;

/*
 * 环形石子问题，数组模拟环
 * Vi小于0的时候，表示蚂蚁讨厌这种食材。
 * 只能搬一次，但是能够搬走连续一段的食材。
 * 因为求得是连续一段，所以最长字段和
 * 方式1，遍历每一个节点，
 * 方式2，求出最长最大字段和，
 * 		在求出最长最小字段和
 * 		总值-最长最小字段和，即为环形的最长字段和
 * 		2者比较，取最大即可
 */
public class 蚂蚁的难题2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();

			/*O(n)^2
			 * int arr[] = new int[2 * (n + 1)];
			 * for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				arr[i + n] = arr[i];
			}
			int resuls = 0;
			for (int i = 1; i <= n; i++) {
				int temp = 0;
				for (int j = i; j < i + n; j++) {
					temp += arr[j];
					if (temp > resuls)
						resuls = temp;
					if (temp < 0)
						temp = 0;
				}
			}*/

			// O(N)
			int temp = 0;
			int temp1 = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int num = 0;
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				num = sc.nextInt();
				sum += num;
				temp += num;
				temp1 += num;
				max = max < temp ? temp : max;
				min = min > temp1 ? temp1 : min;
				if (temp < 0)
					temp = 0;
				if (temp1 > 0)
					temp1 = 0;
			}
			int max2 = sum - min;
			int result = max > max2 ? max : max2;
			System.out.println(result);
		}
	}
}
