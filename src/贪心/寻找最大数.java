package 贪心;
import java.util.Scanner;

/*
 * 假设20里面删除9个，让之后11个按照输入的顺序值最大。
 * 问题就是，在20里面找到11个最大的
 * 第一个肯定在1~1+9之间，
 * 第二个肯定在2~2+9之间，
 * ...
 * 第十一个肯定在11~11+9之间，
 * 问题转换，区间寻找最大值
 */
public class 寻找最大数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			char[] m = sc.next().toCharArray();
			int s = sc.nextInt();
			String str = "";
			int index = -1;// 这里保存区间右边的值
			for (int i = 0; i < m.length - s; i++) {
				char temp = Character.MIN_VALUE;//之所有不能赋值为m[i]是因为可能被str引用。这样也能保证index每次+1
				for (int j = index + 1; j <= i + s; j++) {
					if (temp < m[j]) {
						temp = m[j];
						index = j;
					}
				}
				str += temp;
			}
			System.out.println(str);

		}

	}
}
