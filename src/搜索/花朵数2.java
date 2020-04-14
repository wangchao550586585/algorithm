package ����;




import java.math.BigInteger;
import java.util.Hashtable;

public class ������2 {

	private static final int SIZE = 21;
	private int[] countArray = new int[10]; // �����б�
	private int[] countSumArray = new int[10]; // ��������
	private BigInteger[] sumArray = new BigInteger[10];// ֵ����
	private int offset = 0;// ����

	/**
	 * ���õ�ǰ�����Ӧ�ĸ�����������������ֵ����
	 * 
	 * @param num
	 *            ����
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
	 * ���鵱ǰ�����Ƿ�ƥ��
	 * 
	 * @return
	 */
	private boolean checkPersentArray() {
		BigInteger minVal = sumArray[offset];// ��ǰ�Ѵ���ֵ
		BigInteger maxVal = sumArray[offset].add(p(9 - offset).multiply(
				n(SIZE - countSumArray[offset])));// ��ǰ�Ѵ���ֵ+���ܴ��ڵ����ֵ
		// ��Сֵƥ��
		if (minVal.compareTo(MAX) > 0) {
			return false;
		}
		// ���ֵƥ��
		if (maxVal.compareTo(MIN) < 0) {
			return false;
		}
		String minStr = minVal.compareTo(MIN) > 0 ? minVal.toString() : MIN.toString();
		String maxStr = maxVal.compareTo(MAX) < 0 ? maxVal.toString() : MAX.toString();
		// �ҵ���Сֵ�����ֵ���ײ���ͬ�Ĳ���
		int[] sameCountArray = new int[10];
		for (int i = 0; i < SIZE; i++) {
			char c;
			if ((c = minStr.charAt(i)) == maxStr.charAt(i)) {
				sameCountArray[c - '0'] = sameCountArray[c - '0'] + 1;
			} else {
				break;
			}
		}
		// �ж������ͬ���������ݴ��������Ѽ�¼��λ��������false
		for (int i = 0; i <= offset; i++) {
			if (countArray[i] < sameCountArray[9 - i]) {
				return false;
			}
		}
		// �����ǰֵ������ΪSIZEλ����ô�жϸ�ֵ�ǲ�����Ҫ���ҵ�ֵ
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
	 * �˳�ѭ������ӡ
	 * 
	 * @return
	 */
	private void success() {
		System.out.println("find a match number:" + sumArray[offset]);
	}

	/**
	 * ������ָ����һλ��
	 * 
	 * @return
	 */
	private void next() {
		offset++;
		setValue(SIZE - countSumArray[offset - 1]);
	}

	/**
	 * 
	 * ���˸��꣬�ҵ�����ĸ��꣬����һ
	 * 
	 * @return
	 */
	private boolean back() {
		// ���˸��꣬�ҵ�����ĸ��꣬����һ
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
	 * ���Գ���
	 * 
	 * @param startValue
	 *            ����ƥ�����а���9�ĸ���
	 * @param startTime
	 *            ��������ʱ��
	 */
	private void test(int startValue, long startTime) {
		// ����9�ĸ���
		offset = 0;
		setValue(startValue);
		while (true) {
			if (checkPersentArray()) {// ��鵱ǰ�ύ�����Ƿ�ƥ��
				// ƥ������������ΪSIZE��λ������ô��������ֵ
				if (countSumArray[offset] == SIZE) {
					success();
				}
				// ������ΪSIZE���ҵ�ǰֵ���ڵ�10λ����������0��
				if (offset != 9) {
					next();
					continue;
				}
				// ������ΪSIZE���ҵ�ǰֵ�ڵ�10λ��
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
	 * ������
	 */
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		int s = MAX.divide(p(9)).intValue();
		for (int i = 0; i <= s; i++) {
			// new Main().test(i, startTime);
			// ����ʮ���߳�ͬʱ����
			final int startValue = i;
			new Thread(new Runnable() {

				public void run() {
					new ������2().test(startValue, startTime);
				}
			}).start();
		}
	}

	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger MIN;
	private static final BigInteger MAX;

	/**
	 * 0-SIZE���BigInteger
	 */
	private static final BigInteger n(int i) {
		return (BigInteger) ht.get("n_" + i);
	}

	/**
	 * 0-9�Ĵη���BigInteger
	 */
	private static final BigInteger p(int i) {
		return (BigInteger) ht.get("p_" + i);
	}

	/**
	 * ���ڻ���BigInteger���ݣ�����ʼ��0-SIZE���BigInteger��0-9�Ĵη���BigInteger
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
