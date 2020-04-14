package 贪心;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 必须最快的先打水，这样才能最省时间
 * 譬如1,4,1先打花费时间1,4后打，耗费5，总时间6
 * 反过来的话，4+4+1，总花费8
 */
public class 排队打水问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = m; i < n; i++) {
			arr[i] = arr[i - m] + arr[i];
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += arr[i];
		}
		System.out.println(result);
	}
}
