package 动态规划;
import java.util.Scanner;

/*
 * 问题描述
 生成n个∈[a,b]的随机整数，输出它们的和为x的概率。
 输入格式
 一行输入四个整数依次为n，a，b，x，用空格分隔。
 输出格式
 输出一行包含一个小数位和为x的概率，小数点后保留四位小数
 样例输入
 2 1 3 4
 样例输出
 0.3333
 数据规模和约定
 对于50%的数据，n≤5.
 对于100%的数据，n≤100,b≤100.
 概率，第一个数是1/2，第二个数则是1/4,
 */
public class 概率计算 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		double[][] arr = new double[n + 1][x + 1];// 几个数的和的概率
		double temp = 1.0 / (b - a + 1);
		for (int i = 1; i <= n; i++) {// 取多少个数
			for (int j = i * a; j <= i * b && j <= x; j++) {// 取数值得范围
				if (i == 1)
					arr[i][j] = temp;
				else {
					for (int k = a; k <= b; k++) {// 依赖前一个状态
						if (j >= k)
							arr[i][j] += (arr[i - 1][j - k] * temp);
					}
				}

			}
		}
		System.out.printf("%.4f",arr[n][x]);
	}
}
