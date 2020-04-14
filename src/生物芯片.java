import java.math.BigInteger;
import java.util.Scanner;

public class ÉúÎïÐ¾Æ¬ {
	static final BigInteger TWO = BigInteger.valueOf(2);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		BigInteger sum = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		BigInteger n = sc.nextBigInteger();
		BigInteger mm = f(m);
		BigInteger nn = f(n);
		BigInteger temp;
		if (mm.pow(2).equals(m) && nn.pow(2).equals(nn)) {
			temp = mm.subtract(nn).abs().subtract(BigInteger.ONE);
		} else {
			temp = mm.subtract(nn).abs();
		}
		BigInteger result = m.subtract(n).abs().add(BigInteger.ONE).subtract(
				temp);
		System.out.println(result);

	}
	/*
	 * // y = (y+x/y)/2
	// BigInteger r =(n.divide(l.multiply(two))).add(l.divide(two));
	 */
	private static BigInteger f(BigInteger num) {
		BigInteger f = BigInteger.ONE;
		BigInteger l = (f.add(num.divide(f))).divide(TWO);
		while (!f.equals(l)) {
			f = l;
			l = (f.add(num.divide(f))).divide(TWO);
			if (f.subtract(l).abs().equals(BigInteger.ONE))
				break;
		}
		while (l.pow(2).compareTo(num) > 0) {
			l = l.subtract(BigInteger.ONE);
		}
		while ((l.add(BigInteger.ONE)).pow(2).compareTo(num) <= 0) {
			l = l.add(BigInteger.ONE);
		}
		return l;
	}
}
