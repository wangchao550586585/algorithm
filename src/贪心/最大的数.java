package 贪心;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 问题可以理解为，1的合理加，因为每个数可以和左右2边的数进行加，所有这题重要的就是合理使1加的值与其他数乘最大，
 * 基于3的均衡添加，能保证乘积最大，
 * 因为1和n-1只有1边，所有单独拿出来处理，
 * 第一个为1，加到第二位置即可
 * 第n-1位为1，加到左边最近的非0的上
 * 剩下的是2~n-2范围
 * 因为基于3最大，因为2*1<3
 * 所以遇到传过来的是2直接加，不是2的可能大于2，也可能小于2，针对><2的，均衡添加，优先添加左边，因为右边未知。
 * 特殊情况左边为0，那么左边的索引-1，移到前面那个数上，因为范围n个正整数a[i]（1<=a[i]<=20），所有保证使左边值最大,也算是优先考虑左边的值,
 * 优先向左贪心。
 * 
 * 
 */
public class 最大的数 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		InputStreamReader isr = new InputStreamReader(bis);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while ((str = br.readLine()) != null) {
			int n = Integer.parseInt(str);
			String s[] = br.readLine().split(" ");
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			// 处理边界
			if (n > 1 && arr[0] == 1) {
				arr[1] += 1;
				arr[0] = 0;
			}

			for (int i = 1; i < n - 1; i++) {
				if (arr[i] == 1) {
					arr[i] = 0;
					add(arr, i - 1, i + 1);
				}
			}
			// 处理边界
			if (n > 1 && arr[n - 1] == 1) {
				int index = n - 2;
				while (index >= 0 && arr[index] == 0)
					index--;
				arr[index] += 1;
				arr[n - 1] = 0;
			}
			long result = 1;
			for (int i = 0; i < n; i++) {
				if (arr[i] != 0)
					result = result * arr[i] % 10086;
				;
			}
			System.out.println(result);
		}
	}

	private static void add(int[] arr, int i, int j) {
		//事实证明，基于3的均衡增加的乘积最大,2*1<3
		if (arr[i] == 2) {
			arr[i]++;
			return;
		}
		if (arr[i] == 0)//左边为0说明左边的值加到了右边
			i--;
		//2边均衡
		if (arr[i] <= arr[j]) {
			arr[i]++;
		} else {
			arr[j]++;
		}  
//		arr[i]<=arr[j]?arr[i]++:arr[j]++; c/C++支持

	}
}
