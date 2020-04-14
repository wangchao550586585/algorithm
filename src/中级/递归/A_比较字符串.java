package 中级.递归;
public class A_比较字符串 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		boolean result = fun(s1, s2);
//		boolean result = s1.equals(s2);

		System.out.println(result);
	}

	private static boolean fun(String s1, String s2) {
		/*
		 * 1:比较长度 
		 * 2：比较字符 
		 * 3：截取字符并递归 当长度为0时，说明比较到了最后，且都相等
		 */
		if (s1.length() != s2.length())
			return false;
		if (s1.length() == 0)
			return true;
		if (s1.charAt(0) != s2.charAt(0))
			return false;
		return fun(s1.substring(1), s2.substring(1));
	}

}
