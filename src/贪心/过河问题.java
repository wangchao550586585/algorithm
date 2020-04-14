package 贪心;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 过桥时取最大时间，还要回来送灯
 *保证送灯回来的最快
 *方案1
	 *a[1]+a[0]+a[n]+a[1]
	 *意思是，a1和a2过桥，取a2时间，a1回来送灯，+a1时间，a[n]和a[n-1]过桥，取a[n]时间，a[1]回来送灯
	 *优点:针对跨度小有用，跨度大的没用，跨度指的是a[n]和a[n-1]的时间差,因为取得是最大时间，
 *方案2
	 *	a[n]+a[0]+a[n-1]+a[n],
	 *意思是，每次a[0]送最慢的过桥，然后独自回来送灯。
	 *优点：针对跨度大有用，跨度小的，体现不了时间优越。
 *另外注意，以上是针对4人及以上情况
 *4人以下，统一方案为
 *1:a[0]
 *2:a[1]
 *3:a[2]+a[1]+a[3]||a[3]+a[1]+a[2]
 *	意思为：1和2去，1回，1和3去
 *		1和3去，1回，1和2去，时间一样，但是意思不一样
 */
public class 过河问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			int arr[] = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			/*	if (m == 1) {
					System.out.println(arr[0]);
					continue;
				} else if (m == 2) {
					System.out.println(arr[1]);
					continue;
				} else if (m == 3) {
					System.out.println(arr[0] + arr[1] + arr[2]);
					continue;
				} else {*/
			int j = m - 1;
			int result = 0;
			while (m >= 4) {
				result += Math.min(arr[j] + arr[0] + arr[j - 1] + arr[0],
						arr[1] + arr[0] + arr[j] + arr[1]);
				m -= 2;
				j -= 2;// 便于理解
			}
			// 到这一步，m肯定是少于4人的，人数可能为2||3
			if (m == 1) {
				result = arr[0];
			} else if (m == 2) {
				result += arr[1];
			} else {
				result += arr[0] + arr[1] + arr[2];
			}
			System.out.println(result);
			// }
		}
	}
}
