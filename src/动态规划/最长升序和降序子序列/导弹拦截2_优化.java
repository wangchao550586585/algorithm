package 动态规划.最长升序和降序子序列;
import java.util.Scanner;

/*升序
 * 时间复杂度O(log)
 * 从arr里面每次拿出一个数，跟t数组最后以为进行比较，
 * 			大：放t数组后面
 * 			小：覆盖从t数组往前找最后一个比自己小的，覆盖他前面一个,(利用2分查找)
 * 				t[1]<t<t[2],覆盖t2
 */
public class 导弹拦截2_优化 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		while ((m = sc.nextInt()) != -1) {
			int arr[] = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = sc.nextInt();
			int t[] = new int[m];
			t[0] = arr[0];
			int index = 0;
			for (int i = 1; i < m; i++) {
				if (arr[i] > t[index]) {
					t[++index] = arr[i];
				} else {
					int in = search(arr[i], t, index);
					t[in] = arr[i];
				}
			}
			System.out.println(index + 1);

		}
	}

	private static int search(int num, int[] t, int len) {
		int start = 0;
		int end = len;
		while (start < end) {
			int mid = (start + end) / 2;
			if (t[mid] >= num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
