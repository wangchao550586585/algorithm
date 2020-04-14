package 贪心;

import java.util.Arrays;
import java.util.Scanner;

public class 独木舟上的旅行2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while (k-- > 0) {
			int w = sc.nextInt();
			int n = sc.nextInt();
			int arr[] = new int[n];
			boolean flag[] = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (!flag[i]) {
					c: for (int j = n - 1; j > i; j--) {
						if (!flag[j] && arr[i] + arr[j] <= w) {
							count++;
							flag[j] = true;
							break c;
						} else if (j == i + 1) {
							count++;
							break c;
						}
					}
				}
			}
			System.out.println(flag[n - 1] ? count : count + 1);
		}
	}
}
