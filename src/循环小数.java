
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * ������һ�����ֵ�ѭ��С����ʾ���� 1/7=0.[142857] ������ 1������ 2��С�� ����С�� ����С�� ѭ�� ��ѭ��
 * 
 * @author Administrator
 * 
 */
public class ѭ��С�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����:");
		String num = sc.nextLine();
		String result = getResult(num);
		System.out.println("�����:");
		System.out.println(result);

	}

	private static String getResult(String value) {
		/*
		 * 1:��ȡ���
		 */
		String[] n = value.split(",");
		BigDecimal result = new BigDecimal(n[0]).divide(// ����
				new BigDecimal(n[1]),// ������
				151,// ����С������
				BigDecimal.ROUND_HALF_EVEN);// ���뷽ʽ

		/*
		 * 2:��ȡ�������֣���ȡС������
		 */
		String str = result.toString();
		int indexOf = str.indexOf(".");
		String substring = str.substring(0, indexOf);
		String decimal = str.substring(indexOf + 1, str.length()
				- (indexOf + 1));
		/*
		 * 3����ȡС�� �����ؽ��Ϊnullʱ��˵�����Ϊ����
		 */
		String decimalPart = getDecimalPart(decimal);
		if (decimalPart == null)
			return substring;
		return substring + "." + decimalPart;
	}

	/**
	 * @param decimal
	 * @return
	 */
	private static String getDecimalPart(String decimal) {
		String decimalPart = "";

		/*
		 * 1���ж��Ƿ�Ϊ����С��
		 */
		int index;
		for (index = decimal.length() - 1; index >= 0; index--) {
			if (decimal.charAt(index) != '0')
				break;
		}

		if (index < 0)
			return null;
		else if (index < decimal.length() / 2)
			return decimal = decimal.substring(0, index + 1);

		/*
		 * 2����������С����ѭ���ڵ�
		 */

		char[] arr = decimal.toCharArray();
		for (int k = 0; k < decimal.length(); k++) {
			String findNode = findNode(k, decimal, arr);
			if (findNode != null) {
				decimalPart = decimalPart + "[" + findNode + "]";
				break;
			}
			decimalPart += (arr[k] + "");
		}
		return decimalPart;
	}

	/**
	 * ��ȡ��ͬ�ڵ�
	 * 
	 * @param k
	 * @param index
	 * @param decimal
	 * @param arr
	 * @return
	 * 958924,123234
	 */
	private static String findNode(int k, String decimal, char[] arr) {
		boolean flag;
		String decimalPart = null;
		int index = decimal.indexOf(arr[k], k + 1);
		if (index != -1) {// ˵���ҵ���ͬ��ֵ
			while (index < decimal.length()) {
				flag = true;
				for (int i = k; i < index; i++) {
					if (arr[i] != arr[i + index]) {
						index = decimal.indexOf(arr[index], index + 1);
						flag = false;
						break;
					}
				}
				if (flag) {// ˵�����
					decimalPart = decimal.substring(k, index);
					break;
				}
			}
		}
		return decimalPart;
	}
	// /**
	// * �ж��Ƿ�Ϊ����
	// *
	// * @param result
	// * @return
	// */
	// private static boolean isInt(BigDecimal result) {
	// // 1����ȡ��������
	// String str = result.toString();
	// int indexOf = str.indexOf(".");
	// String value = str.substring(0, indexOf);
	//
	// // �����С����ʾ��
	// BigDecimal re = new BigDecimal(value).divide(// ����
	// new BigDecimal(1),// ������
	// 151,// ����С������
	// BigDecimal.ROUND_HALF_EVEN);// ���뷽ʽ
	// return re.equals(result);
	// }
}
