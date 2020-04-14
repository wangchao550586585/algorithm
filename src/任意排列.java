import java.util.Arrays;

public class »Œ“‚≈≈¡– {
	static int r = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		for (int i = 1; i < arr.length; i++) {
			r = i;
			f(arr, arr.length, r);
		}
	}

	private static void f(int[] arr, int m, int r) {
		for (int i = m; i >= r; i--) {
			arr[r - 1] = i;
			if (r > 1) {
				f(arr, m - 1, r - 1);
			} else {
				printArr(arr);
			}
		}
	}

	private static void printArr(int[] arr) {
		 System.out.println(Arrays.toString(arr));
		/*for (int i = 0; i < r; i++) {
			System.out.println(arr[arr[r] - 1]);
		}*/
	}
}
