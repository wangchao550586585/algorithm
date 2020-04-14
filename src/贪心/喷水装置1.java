package 贪心;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 实际上算的是圆的半径是否大于长方形的斜对角线(也就是三角形的斜边,double d = Math.sqrt(20 * 20 + 1) / 2)。
 * 里面有半径为height/2也就是半径为1的圆，因为保证有足够的喷水装置，所以这种情况可以省略
 * 
 */
public class 喷水装置1 {
	public static void main(String[] args) {
		double d = Math.sqrt(20 * 20 + 1) / 2;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			double[] arr = new double[m];
			int index = 0;
			for (int i = 0; i < m; i++) {
				double k = sc.nextDouble();
				if (k != 1)
					arr[index++] = k;

			}
			Arrays.sort(arr, 0, index);
			double sum = 0;
			int i = index - 1;
			for (; i >= 0; i--) {
				sum += arr[i];
				if (sum > d) {
					break;
				}
			}
			System.out.println(index - i);

		}
	}
}
