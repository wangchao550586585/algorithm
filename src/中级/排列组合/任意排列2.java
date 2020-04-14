package 中级.排列组合;

import java.util.ArrayList;
import java.util.Arrays;

public class 任意排列2 {
	private static int ar[];
	private static ArrayList<boolean[]> resultArr = new ArrayList<boolean[]>();

	public static void main(String[] args) {
		ar = new int[] { 1, 2, 3};
		f(0, new boolean[ar.length]);
		display();
	}

	private static void display() {
		for (boolean[] bs : resultArr) {
			for (int i = 0; i < ar.length; i++) {
				if (bs[i]) {
					System.out.print(ar[i]);
				}
			}
			System.out.println();
		}
	}

	private static void f(int src, boolean[] bs) {
		if (src == ar.length) {
			resultArr.add(Arrays.copyOf(bs, bs.length));
			return;
		}
		bs[src] = true;
		f(src + 1, bs);

		bs[src] = false;
		f(src + 1, bs);

	}
}
