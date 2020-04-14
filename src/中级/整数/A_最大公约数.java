package 中级.整数;

/**
 * a=k*i;
 * b=l*i
 * b-a=(l-k)*i
 * b-a/l-k/a/b有共同的公约数
 * b-a-a-a-a可以换算成b%a
 * b%a=(l*i)%(k*i)=(l%k)*i
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class A_最大公约数 {
	
	public static void main(String[] args) {
		int a = 25, b = 180;
		for (int i = a; i >= 1; i--) {
			if (b % i == 0 && a % i == 0) {
				System.out.println(i);
				break;
			}
		}
		// 辗转相除法
		int temp = 0;
		for (;;) {
			if (a == 0) {
				System.out.println(b);
				break;
			}
			temp = a;
			a = b % a;
			b = temp;
		}
		//递归
		System.out.println(gcd(a, b));
	}

	private static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
}
