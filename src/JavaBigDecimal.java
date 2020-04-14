import java.math.BigDecimal;

public class JavaBigDecimal {

	/**
	 * BigDecimal�ĳ���ʹ�÷�ʽ
	 */
	public static void main(String[] args) {

		// test1();
		// test2();
		test3();

	}

	/**
	 * ���ù��캯���� BigDecimal(int) ����һ�����в�����ָ������ֵ�Ķ��� BigDecimal(double)
	 * ����һ�����в�����ָ��˫����ֵ�Ķ��� BigDecimal(long) ����һ�����в�����ָ��������ֵ�Ķ���
	 * BigDecimal(String) ����һ�����в�����ָ�����ַ�����ʾ����ֵ�Ķ���
	 */
	private static void test1() {
		// BigDecimal(int)
		BigDecimal bg1 = new BigDecimal(1);
		// ֵΪ��1��scaleΪ��0
		System.out.println("ֵΪ��" + bg1 + "��scaleΪ��" + bg1.scale());

		// BigDecimal(double) double�ǲ���ȷ�ġ�
		BigDecimal bg2 = new BigDecimal(0.11);
		// ֵΪ��0.11000000000000000055511151231257827021181583404541015625��scaleΪ��56
		System.out.println("ֵΪ��" + bg2 + "��scaleΪ��" + bg2.scale());

		// BigDecimal(String) String �Ǿ�ȷ�ģ�����һ�����Ƕ���String����ʼ����
		BigDecimal bg3 = new BigDecimal("0.11");
		// ֵΪ��0.11��scaleΪ��2
		System.out.println("ֵΪ��" + bg3 + "��scaleΪ��" + bg3.scale());

	}

	/**
	 * BigDecimal��ֵ=unscaledValue �� 10��-scale�� �Ǳ��ֵ x10�ĸ�scale�η��� �ܽ᣺
	 * �Ǳ��ֵΪȥ��С�����ֵ�� scaleΪС������λ����
	 */
	private static void test2() {
		// ������
		// ���ֵΪ��12345��scaleΪ��0
		// 12345*10�ĸ�0�η�=12345
		// �Ǳ��ֵΪ12345 ��scaleΪ0
		BigDecimal bg1 = new BigDecimal("12345");
		System.out.println("���ֵΪ��" + bg1 + "��scaleΪ��" + bg1.scale());

		// ������
		// ���ֵΪ��-12345��scaleΪ��0
		// -12345*10�ĸ�0�η�=-12345
		// �Ǳ��ֵΪ-12345 ��scaleΪ0
		BigDecimal bg2 = new BigDecimal("-12345");
		System.out.println("���ֵΪ��" + bg2 + "��scaleΪ��" + bg2.scale());

		// ��С��
		// ���ֵΪ��12345.12345��scaleΪ��5
		// 1234512345*10�ĸ�5�η�=12345.12345
		// �Ǳ��ֵΪ1234512345 ��scaleΪ5
		BigDecimal bg4 = new BigDecimal("12345.12345");
		System.out.println("���ֵΪ��" + bg4 + "��scaleΪ��" + bg4.scale());

		// ��С��
		// ���ֵΪ��-12345.12345��scaleΪ��5
		// -1234512345*10�ĸ�5�η�=-12345.12345
		// �Ǳ��ֵΪ-1234512345 ��scaleΪ5
		BigDecimal bg5 = new BigDecimal("-12345.12345");
		System.out.println("���ֵΪ��" + bg5 + "��scaleΪ��" + bg5.scale());

	}

	/**
	 * bg1.setScale(0)�᷵��һ���µ�BigDecimal�Ķ��󡣲����bg1�ĵ��� BigDecimal�ڴ�����ʱ��Ͳ���ı��ˡ�
	 */
	private static void test3() {

		/**
		 * setScale(int i):ʵ��������ģʽΪROUND_UNNECESSARY ����һ��
		 * BigDecimal������Ϊָ��ֵ����ֵ����ֵ�ϵ��ڴ� BigDecimal ��ֵ�� ����ⲻ���ܣ����׳�
		 * ArithmeticException�� �˵���ͨ���������ӱ�ȣ�����������£����Ա�֤����ָ����Ⱥ���ȷֵ�� BigDecimal��
		 * ������÷�֪�� BigDecimal����С�����ֵĽ�β���㹻����㣨��������ֵ�е�ʮ�����ӣ���
		 * ��õ���Ҳ�����ڼ��ٱ�ȣ����������±�ȣ�����������ֵ��
		 */

		BigDecimal bg1 = new BigDecimal("0.01");
		BigDecimal bg2 = new BigDecimal("1.14");
		BigDecimal bg3 = new BigDecimal("1.15");

		BigDecimal bg4 = bg1.setScale(5);
		// bg1.setScale(0)�᷵��һ���µ�BigDecimal�Ķ��󡣲����bg1�ĵ���
		System.out.println(bg4);// 0.01000
		System.out.println(bg1);// 0.01
		// ���쳣java.lang.ArithmeticException: Rounding necessary
		// bg2=bg1.setScale(0);
		// ���쳣java.lang.ArithmeticException: Rounding necessary
		// bg3=bg1.setScale(1);

		/**
		 * ROUND_UP��Զ���������ģʽ��ֱ�ӽ�λ
		 * 
		 */
		System.out.println("ROUND_UP");
		bg1 = new BigDecimal("0.01");
		bg2 = new BigDecimal("1.14");
		bg3 = new BigDecimal("1.15");
		BigDecimal bg5 = bg1.setScale(1, BigDecimal.ROUND_UP);// 0.1
		System.out.println(bg5);
		bg5 = bg2.setScale(1, BigDecimal.ROUND_UP);// 1.2
		System.out.println(bg5);
		bg5 = bg3.setScale(1, BigDecimal.ROUND_UP);// 1.2
		System.out.println(bg5);

		/**
		 * ROUND_DOWN:�ӽ��������ģʽ��ֱ����ȥ
		 */
		System.out.println("ROUND_DOWN");
		bg1 = new BigDecimal("0.01");
		bg2 = new BigDecimal("1.14");
		bg3 = new BigDecimal("1.15");
		bg5 = bg1.setScale(1, BigDecimal.ROUND_DOWN);// 0.0
		System.out.println(bg5);
		bg5 = bg2.setScale(1, BigDecimal.ROUND_DOWN);// 1.1
		System.out.println(bg5);
		bg5 = bg3.setScale(1, BigDecimal.ROUND_DOWN);// 1.1
		System.out.println(bg5);

		/**
		 * ROUND_CEILING: �ӽ�������������ģʽ����� BigDecimal Ϊ������������Ϊ�� ROUND_UP ��ͬ��
		 * ���Ϊ������������Ϊ�� ROUND_DOWN ��ͬ��ע�⣬������ģʽʼ�ղ�����ټ���ֵ��
		 * 
		 */

		/**
		 * ROUND_FLOOR �ӽ�������������ģʽ����� BigDecimal Ϊ������������Ϊ�� ROUND_DOWN ��ͬ��
		 * ���Ϊ������������Ϊ�� ROUND_UP ��ͬ��ע�⣬������ģʽʼ�ղ������Ӽ���ֵ��
		 * 
		 */

		/**
		 * ROUND_HALF_UP 4��5��
		 * 
		 * 
		 */
		System.out.println("ROUND_HALF_UP");
		bg1 = new BigDecimal("0.01");
		bg2 = new BigDecimal("1.14");
		bg3 = new BigDecimal("1.15");
		bg5 = bg1.setScale(1, BigDecimal.ROUND_HALF_UP);// 0.0
		System.out.println(bg5);
		bg5 = bg2.setScale(1, BigDecimal.ROUND_HALF_UP);// 1.1
		System.out.println(bg5);
		bg5 = bg3.setScale(1, BigDecimal.ROUND_HALF_UP);// 1.2
		System.out.println(bg5);

		/**
		 * ROUND_HALF_DOWN 5��6��
		 * 
		 */
		System.out.println("ROUND_HALF_DOWN");
		bg1 = new BigDecimal("0.01");
		bg2 = new BigDecimal("1.14");
		bg3 = new BigDecimal("1.16");
		bg5 = bg1.setScale(1, BigDecimal.ROUND_HALF_DOWN);// 0.0
		System.out.println(bg5);
		bg5 = bg2.setScale(1, BigDecimal.ROUND_HALF_DOWN);//
		System.out.println(bg5);
		bg5 = bg3.setScale(1, BigDecimal.ROUND_HALF_DOWN);//
		System.out.println(bg5);

		/**
		 * ROUND_HALF_EVEN
		 * ����ӽ��ġ��������룬����������������ֵľ�����ȣ��������ڵ�ż�����롣�������������ߵ�����Ϊ��������������Ϊ��
		 * ROUND_HALF_UP ��ͬ�� ���Ϊż������������Ϊ�� ROUND_HALF_DOWN
		 * ��ͬ��ע�⣬���ظ�����һϵ�м���ʱ��������ģʽ���Խ��ۼӴ��������С��
		 * 
		 * 
		 */

		/**
		 * ROUND_UNNECESSARY ��������Ĳ������о�ȷ�Ľ������˲���Ҫ���롣����Ի�þ�ȷ����Ĳ���ָ��������ģʽ�����׳�
		 * ArithmeticException��
		 */

	}

	/**
	 * �� �� �� ��
	 */
	private static void test4() {

	}

}