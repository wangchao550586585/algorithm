import java.util.Arrays;

public class »Œ“‚ {
	public static void main(String[] args) {
		f(new int[] { 1, 2, 3, 4, 5 }, 0, new boolean[3]);

	}

	private static void f(int[] is, int index, boolean[] bs) {
		if (index == bs.length) {
			System.out.println(Arrays.toString(bs));
			return;
		}
		bs[index] = true;
		f(is, index + 1, bs);
		bs[index] = false;
		f(is, index + 1, bs);
	}
}
