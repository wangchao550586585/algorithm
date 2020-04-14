package 搜索;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 
 * @author wc
 * 
 */
public class 盾神与砝码称重 {
	static class Scanner {

		private InputStream is = System.in;

		public int nextInt() {
			try {
				int i;

				while ((i = is.read()) < 45 || i > 57) {
				}

				int mark = 1, temp = 0;

				if (i == 45) {
					mark = -1;
					i = is.read();
				}

				while (i > 47 && i < 58) {
					temp = temp * 10 + i - 48;
					i = is.read();
				}

				return temp * mark;
			} catch (IOException e) {
				e.printStackTrace();
			}

			return -1;
		}
	}

	static int[] arr;
	static int temp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n];
		temp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		temp[0] = arr[0];
		for (int i = 1; i < n; i++)
			temp[i] = temp[i - 1] + arr[i];
		
		Arrays.sort(arr);
		
		while (m-- > 0) {
			System.out.println(dfs(sc.nextInt(), n - 1) ? "YES" : "NO");
		}
	}

	static boolean dfs(int weigh, int i) {
		if (weigh == 0) {
			return true;
		}
		if (i < 0 || Math.abs(weigh) > temp[i]) {// i<0省略策略，arr[-1]=0数组最低0，所以可以逆推，arr[n]=0
			return false;
		}
		for (; i >= 0; i--) {
			if (dfs(weigh - arr[i], i - 1) || dfs(weigh + arr[i], i - 1)) {
				return true;
			}
		}
		return false;
	}
}