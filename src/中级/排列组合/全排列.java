package 中级.排列组合;

import java.util.Arrays;
public class 全排列 {

	public static void main(String[] args) {
		char[] c = { 'a', 'b', 'c','d' };
		f(c, 0);
	}

	/**
	 * @param c
	 *            ,排列数组
	 * @param k
	 *            ，当前交换位置索引
	 */
	private static void f(char[] c, int k) {
		/*
		 * 1: 显示
		 */
		if (k == c.length - 1) {
			System.out.println(Arrays.toString(c));
		}
		/*
		 * 2: 每一个数与索引为0的数进行交换，每次交换后，利用递归排列后面的
		 * 	注意：有出口，所以无需设置return条件
		 */
		for (int i = k; i < c.length; i++) {
			{// 试探(交换)
				char temp = c[i];
				c[i] = c[k];
				c[k] = temp;
			}
			f(c, k + 1);//排列后面
			{// 回溯(换回来，恢复原来位置)
				char temp = c[i];
				c[i] = c[k];
				c[k] = temp;
			}

		}

	}
}
