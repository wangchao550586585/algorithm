package 中级.博弈;

import java.util.Scanner;

/**
 * 典型尼姆游戏问题，组合博弈论
 * 尼姆定理：无偏的2人游戏(2人共同操作一堆数据，与其相反的象棋)=尼姆堆
 * 
 * 3,4,5，可以从这三堆中拿走任何数量
 * 二进制规律
 * 0011
 * 0100
 * 0101
 * 竖行方向下，编程偶数就行，0也是偶数。处于这种情况对方必输
 * 
 * 高僧斗法转换为尼姆游戏
 * 小和尚位置间的距离，尼姆堆
 * 偶数，22组合
 * 奇数，最高阶补充假的
 * 
 * 保持不败:小组跟随操作，不改变尼姆堆值
 * @author Administrator
 * 
 */
public class E_高僧斗法 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ss = sc.nextLine().split(" ");
		int[] x = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			x[i] = Integer.parseInt(ss[i]);
		test(x);

	}

	private static void test(int[] x) {
		for (int i = 0; i < x.length - 1; i++) {
			for (int k = x[i] + 1; k < x[i + 1]; k++) {
				int old = x[i];
				x[i] = k;
				try {
					if (f(x))
						System.out.println(old + " " + k);
				} finally {
					x[i] = old;
				}
			}
		}

	}

	private static boolean f(int[] x) {
		String[] y = new String[x.length / 2];
		int m = 0;
		for (int i = 0; i < x.length / 2; i++) {
			y[i] = Integer.toBinaryString(x[i * 2 + 1] - x[i * 2] - 1);
			if (y[i].length() > m)
				m = y[i].length();
		}
		for (int i = 0; i < m; i++) {
			boolean tag = true;
			for (int j = 0; j < y.length; j++) {
				int k = y[j].length() - (m - i);
				if (k >= 0 && y[j].charAt(k) == '1')
					tag = !tag;
			}
			if (tag == false)
				return false;
		}

		return true;
	}
}
