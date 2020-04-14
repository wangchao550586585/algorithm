package 中级.整数;
/**
 * 筛选法
 * 2，3，5,7...倍数全部筛除
 * @author Administrator
 *
 */
public class C_十万零二个素数 {
	public static void main(String[] args) {
		int N = 1000 * 1000 * 10;
		int x = 10001;
		byte[] a = new byte[N];

		for (int i = 2; i < N / 2; i++) {
			if (a[i] == 1)//合数不筛除
				continue;
			for (int k = 2; k <= N / i; k++) {
				if (i * k < N)
					a[i * k] = 1;
			}
		}

		int m = 0;
		for (int i = 2; i < N; i++) {
			if (a[i] == 0) {
				m++;
				if (m == x)
					System.out.println(i + " ");
			}
		}

	}

}
