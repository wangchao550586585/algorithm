
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 《给出一个数字的循环小数表示法》 1/7=0.[142857] 分析： 1：整数 2：小数 有限小数 无限小数 循环 不循环
 * 
 * @author Administrator
 * 
 */
public class 循环小数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入:");
		String num = sc.nextLine();
		String result = getResult(num);
		System.out.println("则输出:");
		System.out.println(result);

	}

	private static String getResult(String value) {
		/*
		 * 1:获取结果
		 */
		String[] n = value.split(",");
		BigDecimal result = new BigDecimal(n[0]).divide(// 运算
				new BigDecimal(n[1]),// 被除数
				151,// 保留小数长度
				BigDecimal.ROUND_HALF_EVEN);// 舍入方式

		/*
		 * 2:截取整数部分，截取小数部分
		 */
		String str = result.toString();
		int indexOf = str.indexOf(".");
		String substring = str.substring(0, indexOf);
		String decimal = str.substring(indexOf + 1, str.length()
				- (indexOf + 1));
		/*
		 * 3：获取小数 当返回结果为null时，说明结果为整数
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
		 * 1：判断是否为有限小数
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
		 * 2：返回无限小数的循环节点
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
	 * 获取相同节点
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
		if (index != -1) {// 说明找到相同的值
			while (index < decimal.length()) {
				flag = true;
				for (int i = k; i < index; i++) {
					if (arr[i] != arr[i + index]) {
						index = decimal.indexOf(arr[index], index + 1);
						flag = false;
						break;
					}
				}
				if (flag) {// 说明相等
					decimalPart = decimal.substring(k, index);
					break;
				}
			}
		}
		return decimalPart;
	}
	// /**
	// * 判断是否为整数
	// *
	// * @param result
	// * @return
	// */
	// private static boolean isInt(BigDecimal result) {
	// // 1：获取整数部分
	// String str = result.toString();
	// int indexOf = str.indexOf(".");
	// String value = str.substring(0, indexOf);
	//
	// // 换算成小数表示。
	// BigDecimal re = new BigDecimal(value).divide(// 运算
	// new BigDecimal(1),// 被除数
	// 151,// 保留小数长度
	// BigDecimal.ROUND_HALF_EVEN);// 舍入方式
	// return re.equals(result);
	// }
}
