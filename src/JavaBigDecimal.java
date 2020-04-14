import java.math.BigDecimal;

public class JavaBigDecimal {

	/**
	 * BigDecimal的常用使用方式
	 */
	public static void main(String[] args) {

		// test1();
		// test2();
		test3();

	}

	/**
	 * 常用构造函数： BigDecimal(int) 创建一个具有参数所指定整数值的对象。 BigDecimal(double)
	 * 创建一个具有参数所指定双精度值的对象。 BigDecimal(long) 创建一个具有参数所指定长整数值的对象。
	 * BigDecimal(String) 创建一个具有参数所指定以字符串表示的数值的对象。
	 */
	private static void test1() {
		// BigDecimal(int)
		BigDecimal bg1 = new BigDecimal(1);
		// 值为：1，scale为：0
		System.out.println("值为：" + bg1 + "，scale为：" + bg1.scale());

		// BigDecimal(double) double是不精确的。
		BigDecimal bg2 = new BigDecimal(0.11);
		// 值为：0.11000000000000000055511151231257827021181583404541015625，scale为：56
		System.out.println("值为：" + bg2 + "，scale为：" + bg2.scale());

		// BigDecimal(String) String 是精确的，所以一般我们都用String来初始化。
		BigDecimal bg3 = new BigDecimal("0.11");
		// 值为：0.11，scale为：2
		System.out.println("值为：" + bg3 + "，scale为：" + bg3.scale());

	}

	/**
	 * BigDecimal的值=unscaledValue × 10（-scale） 非标度值 x10的负scale次方。 总结：
	 * 非标度值为去掉小数点的值。 scale为小数点后的位数。
	 */
	private static void test2() {
		// 正整数
		// 输出值为：12345，scale为：0
		// 12345*10的负0次方=12345
		// 非标度值为12345 ，scale为0
		BigDecimal bg1 = new BigDecimal("12345");
		System.out.println("输出值为：" + bg1 + "，scale为：" + bg1.scale());

		// 负整数
		// 输出值为：-12345，scale为：0
		// -12345*10的负0次方=-12345
		// 非标度值为-12345 ，scale为0
		BigDecimal bg2 = new BigDecimal("-12345");
		System.out.println("输出值为：" + bg2 + "，scale为：" + bg2.scale());

		// 正小数
		// 输出值为：12345.12345，scale为：5
		// 1234512345*10的负5次方=12345.12345
		// 非标度值为1234512345 ，scale为5
		BigDecimal bg4 = new BigDecimal("12345.12345");
		System.out.println("输出值为：" + bg4 + "，scale为：" + bg4.scale());

		// 负小数
		// 输出值为：-12345.12345，scale为：5
		// -1234512345*10的负5次方=-12345.12345
		// 非标度值为-1234512345 ，scale为5
		BigDecimal bg5 = new BigDecimal("-12345.12345");
		System.out.println("输出值为：" + bg5 + "，scale为：" + bg5.scale());

	}

	/**
	 * bg1.setScale(0)会返回一个新的BigDecimal的对象。不会把bg1改掉。 BigDecimal在创建的时候就不会改变了。
	 */
	private static void test3() {

		/**
		 * setScale(int i):实际上舍入模式为ROUND_UNNECESSARY 返回一个
		 * BigDecimal，其标度为指定值，其值在数值上等于此 BigDecimal 的值。 如果这不可能，则抛出
		 * ArithmeticException。 此调用通常用于增加标度，在这种情况下，可以保证存在指定标度和正确值的 BigDecimal。
		 * 如果调用方知道 BigDecimal在其小数部分的结尾有足够多的零（即其整数值中的十的因子），
		 * 则该调用也可用于减少标度，以允许重新标度，而不更改其值。
		 */

		BigDecimal bg1 = new BigDecimal("0.01");
		BigDecimal bg2 = new BigDecimal("1.14");
		BigDecimal bg3 = new BigDecimal("1.15");

		BigDecimal bg4 = bg1.setScale(5);
		// bg1.setScale(0)会返回一个新的BigDecimal的对象。不会把bg1改掉。
		System.out.println(bg4);// 0.01000
		System.out.println(bg1);// 0.01
		// 抛异常java.lang.ArithmeticException: Rounding necessary
		// bg2=bg1.setScale(0);
		// 抛异常java.lang.ArithmeticException: Rounding necessary
		// bg3=bg1.setScale(1);

		/**
		 * ROUND_UP：远离零的舍入模式，直接进位
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
		 * ROUND_DOWN:接近零的舍入模式，直接舍去
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
		 * ROUND_CEILING: 接近正无穷大的舍入模式。如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同；
		 * 如果为负，则舍入行为与 ROUND_DOWN 相同。注意，此舍入模式始终不会减少计算值。
		 * 
		 */

		/**
		 * ROUND_FLOOR 接近负无穷大的舍入模式。如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同；
		 * 如果为负，则舍入行为与 ROUND_UP 相同。注意，此舍入模式始终不会增加计算值。
		 * 
		 */

		/**
		 * ROUND_HALF_UP 4舍5入
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
		 * ROUND_HALF_DOWN 5舍6入
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
		 * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。如果舍弃部分左边的数字为奇数，则舍入行为与
		 * ROUND_HALF_UP 相同； 如果为偶数，则舍入行为与 ROUND_HALF_DOWN
		 * 相同。注意，在重复进行一系列计算时，此舍入模式可以将累加错误减到最小。
		 * 
		 * 
		 */

		/**
		 * ROUND_UNNECESSARY 断言请求的操作具有精确的结果，因此不需要舍入。如果对获得精确结果的操作指定此舍入模式，则抛出
		 * ArithmeticException。
		 */

	}

	/**
	 * 加 减 乘 除
	 */
	private static void test4() {

	}

}