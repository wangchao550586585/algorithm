package 搜索;


import java.math.BigInteger;

public class 花朵数的研究 {
	public static void main(String[] args) {
		// 统计0-9出现次数
		int arr[] = new int[10];
		// 参数2：初始值
		// 参数3：出现次数
		fun(arr, 0, 0);
	}

	/**
	 * 1：缓存0-9的21次方值
	 */
	static BigInteger[] bi = { BigInteger.ZERO, g(1), g(2), g(3), g(4), g(5),
			g(6), g(7), g(8), g(9), };

	private static BigInteger g(int num) {
		BigInteger value = BigInteger.valueOf(num);// 初始值
		BigInteger result = value;// 结果
		for (int i = 1; i < 21; i++) {
			result = result.multiply(value);
		}
		return result;
	}

	/**
	 * 2: 0-9出现次数总计21次的所有排列
	 * 
	 * @param arr
	 * @param value
	 * @param count
	 */
	private static void fun(int[] arr, int value, int count) {
		// 终止条件，当value=9，说明排列到了数组最后一个值，直接21-count得到剩下出现次数，然后运算。
		if (value == 9) {
			arr[9] = 21 - count;
			operation(arr);
			return;
		}
		for (int i = 0; i <= 21 - count; i++) {
			arr[value] = i;
			fun(arr, value + 1, count + i);
		}

	}

	/**
	 * 3：运算
	 * 
	 * @param arr
	 */
	private static void operation(int[] arr) {
		BigInteger result = BigInteger.ZERO;// 初始值
		// 1:获取和
		for (int i = 0; i < 10; i++) {// 遍历arr
			result = result.add(bi[i].multiply(BigInteger.valueOf(arr[i])));
		}
		// 判断和长度是否为21位
		String resStr = result + "";
		int rsleng = resStr.length();
		if (rsleng != 21)
			return;
		// 统计和中0-9出现次数
		int[] count = new int[10];
		for (int i = 0; i < rsleng; i++) {
			count[resStr.charAt(i) - '0']++;
		}
		// 判断count==arr
		for (int i = 0; i < 10; i++) {
			if (count[i] != arr[i])
				return;
		}

		// 匹配成功
		System.out.println(resStr);

	}

}
