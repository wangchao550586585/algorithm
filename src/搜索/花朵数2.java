package 搜索;




import java.math.BigInteger;
import java.util.Hashtable;

public class 花朵数2 {

	private static final int SIZE = 21;
	private int[] countArray = new int[10]; // 个数列表
	private int[] countSumArray = new int[10]; // 个数总数
	private BigInteger[] sumArray = new BigInteger[10];// 值总数
	private int offset = 0;// 浮标

	/**
	 * 设置当前浮标对应的个数，个数的总数，值总数
	 * 
	 * @param num
	 *            个数
	 */
	private void setValue(int num) {
		countArray[offset] = num;
		if (offset == 0) {
			countSumArray[offset] = num;
			sumArray[offset] = p(9 - offset).multiply(n(num));
		} else {
			countSumArray[offset] = countSumArray[offset - 1] + num;
			sumArray[offset] = sumArray[offset - 1].add(p(9 - offset).multiply(n(num)));
		}
	}

	/**
	 * 检验当前数据是否匹配
	 * 
	 * @return
	 */
	private boolean checkPersentArray() {
		BigInteger minVal = sumArray[offset];// 当前已存在值
		BigInteger maxVal = sumArray[offset].add(p(9 - offset).multiply(
				n(SIZE - countSumArray[offset])));// 当前已存在值+可能存在的最大值
		// 最小值匹配
		if (minVal.compareTo(MAX) > 0) {
			return false;
		}
		// 最大值匹配
		if (maxVal.compareTo(MIN) < 0) {
			return false;
		}
		String minStr = minVal.compareTo(MIN) > 0 ? minVal.toString() : MIN.toString();
		String maxStr = maxVal.compareTo(MAX) < 0 ? maxVal.toString() : MAX.toString();
		// 找到最小值与最大值间首部相同的部分
		int[] sameCountArray = new int[10];
		for (int i = 0; i < SIZE; i++) {
			char c;
			if ((c = minStr.charAt(i)) == maxStr.charAt(i)) {
				sameCountArray[c - '0'] = sameCountArray[c - '0'] + 1;
			} else {
				break;
			}
		}
		// 判断如果相同部分有数据大于现在已记录的位数，返回false
		for (int i = 0; i <= offset; i++) {
			if (countArray[i] < sameCountArray[9 - i]) {
				return false;
			}
		}
		// 如果当前值的总数为SIZE位，那么判断该值是不是需要查找的值
		if (countSumArray[offset] == SIZE) {
			String sumStr = sumArray[offset].toString();
			BigInteger sum = ZERO;
			for (int i = 0; i < sumStr.length(); i++) {
				sum = sum.add(p(sumStr.charAt(i) - '0'));
			}
			return sum.compareTo(sumArray[offset]) == 0;
		}
		return true;
	}

	/**
	 * 退出循环，打印
	 * 
	 * @return
	 */
	private void success() {
		System.out.println("find a match number:" + sumArray[offset]);
	}

	/**
	 * 将浮标指向下一位数
	 * 
	 * @return
	 */
	private void next() {
		offset++;
		setValue(SIZE - countSumArray[offset - 1]);
	}

	/**
	 * 
	 * 回退浮标，找到最近的浮标，并减一
	 * 
	 * @return
	 */
	private boolean back() {
		// 回退浮标，找到最近的浮标，并减一
		if (countArray[offset] == 0) {
			while (countArray[offset] == 0) {
				if (offset > 0) {
					offset--;
				} else {
					return true;
				}
			}
		}
		if (offset > 0) {
			setValue(countArray[offset] - 1);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 测试程序
	 * 
	 * @param startValue
	 *            测试匹配数中包含9的个数
	 * @param startTime
	 *            程序启动时间
	 */
	private void test(int startValue, long startTime) {
		// 设置9的个数
		offset = 0;
		setValue(startValue);
		while (true) {
			if (checkPersentArray()) {// 检查当前提交数据是否匹配
				// 匹配且总数正好为SIZE的位数，那么就是求解的值
				if (countSumArray[offset] == SIZE) {
					success();
				}
				// 总数不为SIZE，且当前值不在第10位（即不等于0）
				if (offset != 9) {
					next();
					continue;
				}
				// 总数不为SIZE，且当前值在第10位。
				if (back()) {
					break;
				}
			} else {
				if (back()) {
					break;
				}
			}
		}

		/*System.out.println(Thread.currentThread() + " End,Spend time "
				+ (System.currentTimeMillis() - startTime) / 1000 + "s");*/
	}

	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		int s = MAX.divide(p(9)).intValue();
		for (int i = 0; i <= s; i++) {
			// new Main().test(i, startTime);
			// 启动十个线程同时运算
			final int startValue = i;
			new Thread(new Runnable() {

				public void run() {
					new 花朵数2().test(startValue, startTime);
				}
			}).start();
		}
	}

	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger MIN;
	private static final BigInteger MAX;

	/**
	 * 0-SIZE间的BigInteger
	 */
	private static final BigInteger n(int i) {
		return (BigInteger) ht.get("n_" + i);
	}

	/**
	 * 0-9的次方的BigInteger
	 */
	private static final BigInteger p(int i) {
		return (BigInteger) ht.get("p_" + i);
	}

	/**
	 * 用于缓存BigInteger数据，并初始化0-SIZE间的BigInteger和0-9的次方的BigInteger
	 */
	private static Hashtable<String, Object> ht = new Hashtable<String, Object>();

	static {
		int s = SIZE < 10 ? 10 : SIZE;
		for (int i = 0; i <= s; i++) {
			ht.put("n_" + i, new BigInteger(String.valueOf(i)));
		}
		for (int i = 0; i <= 10; i++) {
			ht.put("p_" + i, new BigInteger(String.valueOf(i)).pow(SIZE));
		}
		MIN = n(10).pow(SIZE - 1);
		MAX = n(10).pow(SIZE).subtract(n(1));
	}

}
