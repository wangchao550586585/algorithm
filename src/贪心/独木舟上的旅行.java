package 贪心;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 排序，然后找搭档过河,找不到搭档的单独过河，找的到搭档的，和搭档过河。
 */
public class 独木舟上的旅行 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int w = sc.nextInt();
			int m = sc.nextInt();
			int arr[] = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			int count = 0;
			for (int i = 0, j = m - 1; i <= j;) {// 编号交叉的时候，说明只剩下一个人了。
				if (arr[i] + arr[j] <= w) {// 找得到搭档的话
					i++;
					j--;
					count++;
				} else {// 找不到搭档的话
					j--;
					count++;
				}
			}
			System.out.println(count);

		}
	}
}
