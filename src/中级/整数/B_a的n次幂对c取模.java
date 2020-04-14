package 中级.整数;

public class B_a的n次幂对c取模 {
	public static void main(String[] args) {
		System.out.println(f(3, 2, 1));
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 * (x*a*a*a)%c=(x%c)*(a%c)...
	 */
	private static int f(int a, int b, int c) {
		int x = 1;
		for (int i = 0; i < b; i++)
			x = (x * a) % c;
		return x;
	}
}
