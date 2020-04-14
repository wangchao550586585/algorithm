package 贪心;
import java.util.Scanner;

/*
 * 加减字符串，保证+在对应的地方，-自然也在对应的地方
 * 1：保存每个+号的位置
 * 2：减去2者之差，既是交换位置的值
 */
public class 加减字符串 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			char[] src = sc.next().toCharArray();
			char[] dest = sc.next().toCharArray();
			int src1[] = new int[src.length];
			int dest1[] = new int[dest.length];
			int j = 0;
			int k = 0;
			for (int i = 0; i < src.length; i++) {
				if (src[i] == '+') {
					src1[j++] = i;
				}
				if (dest[i] == '+') {
					dest1[k++] = i;
				}
			}
			int result = 0;
			for (int i = 0; i < src.length; i++) {
				result += Math.abs(dest1[i] - src1[i]);
			}
			System.out.println(result);

		}
	}
}
