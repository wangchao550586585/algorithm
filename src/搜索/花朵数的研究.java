package ����;


import java.math.BigInteger;

public class ���������о� {
	public static void main(String[] args) {
		// ͳ��0-9���ִ���
		int arr[] = new int[10];
		// ����2����ʼֵ
		// ����3�����ִ���
		fun(arr, 0, 0);
	}

	/**
	 * 1������0-9��21�η�ֵ
	 */
	static BigInteger[] bi = { BigInteger.ZERO, g(1), g(2), g(3), g(4), g(5),
			g(6), g(7), g(8), g(9), };

	private static BigInteger g(int num) {
		BigInteger value = BigInteger.valueOf(num);// ��ʼֵ
		BigInteger result = value;// ���
		for (int i = 1; i < 21; i++) {
			result = result.multiply(value);
		}
		return result;
	}

	/**
	 * 2: 0-9���ִ����ܼ�21�ε���������
	 * 
	 * @param arr
	 * @param value
	 * @param count
	 */
	private static void fun(int[] arr, int value, int count) {
		// ��ֹ��������value=9��˵�����е����������һ��ֵ��ֱ��21-count�õ�ʣ�³��ִ�����Ȼ�����㡣
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
	 * 3������
	 * 
	 * @param arr
	 */
	private static void operation(int[] arr) {
		BigInteger result = BigInteger.ZERO;// ��ʼֵ
		// 1:��ȡ��
		for (int i = 0; i < 10; i++) {// ����arr
			result = result.add(bi[i].multiply(BigInteger.valueOf(arr[i])));
		}
		// �жϺͳ����Ƿ�Ϊ21λ
		String resStr = result + "";
		int rsleng = resStr.length();
		if (rsleng != 21)
			return;
		// ͳ�ƺ���0-9���ִ���
		int[] count = new int[10];
		for (int i = 0; i < rsleng; i++) {
			count[resStr.charAt(i) - '0']++;
		}
		// �ж�count==arr
		for (int i = 0; i < 10; i++) {
			if (count[i] != arr[i])
				return;
		}

		// ƥ��ɹ�
		System.out.println(resStr);

	}

}
