package ̰��;
import java.util.Arrays;
import java.util.Scanner;

/*
 * ���������ȴ�ˮ������������ʡʱ��
 * Ʃ��1,4,1�ȴ򻨷�ʱ��1,4��򣬺ķ�5����ʱ��6
 * �������Ļ���4+4+1���ܻ���8
 */
public class �ŶӴ�ˮ���� {
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
