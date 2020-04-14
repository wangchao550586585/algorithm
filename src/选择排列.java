import java.util.Arrays;

public class —°‘Ò≈≈¡– {
	public static void main(String[] args) {
		f(new int[] { 1, 2, 3, 4, 5 }, 0, new boolean[5], 3);

	}

	private static void f(int[] is, int index, boolean[] bs, int count) {
		if (index == bs.length&&count==0) {
			for (int i = 0; i < 5; i++) {
				if (bs[i])
					System.out.print(is[i]);
			}
			System.out.println();
			return;
		}
		if (index == bs.length) {
			return;
		}
		bs[index] = true;
		f(is, index + 1, bs, count - 1);
		bs[index] = false;
		f(is, index + 1, bs, count);
	}
}
