

public class 整数的划分 {
	public static void main(String[] args) {
		f(6, 0, new int[6]);
	}

	private static void f(int num, int index, int[] is) {
		if (num <= 0) {
			for (int i = 0; i < index; i++) {
				System.out.print(is[i] + " ");
			}
			System.out.println();
		}
		for (int i = num; i > 0; i--) {
			if (index>0&&is[index-1] < i)
				continue;
			is[index] = i;
			f(num - i, index + 1, is);
		}

	}
}
