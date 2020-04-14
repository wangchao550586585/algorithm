package 动态规划;

import java.util.Scanner;

public class 格子刷油漆 {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1)
			System.out.println(2);
		else
			f(n);
		sc.close();
	}

	private static void f(int n) {
		long a[] = new long[n + 1];
		long b[] = new long[n + 1];
		a[1] = 1;
		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] * 2 % MOD;
		}
		b[1] = 1;
		b[2] = 6;
		for (int i = 3; i <= n; i++) {
			b[i] = (b[i - 1] * 2 + a[i] + b[i - 2] * 4) % MOD;
		}
		long result = b[n] * 4;
		for (int i = 2; i <= n - 1; i++) {
			result = (result + (8 * a[i - 1] * b[n - i ] + 8 * a[n - i ]
					* b[i - 1])
					% MOD)
					% MOD;
		}
		System.out.println(result);
	}

}
