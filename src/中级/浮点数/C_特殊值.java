package 中级.浮点数;

import java.math.BigDecimal;
import java.math.MathContext;
/*
 * *
形式		指数			小数部分
零		0			0
非正规形式	0			非0
正规形式	1到2e-2		任意
无穷		2e-1		0
NaN		2e-1		非零
 */
public class C_特殊值 {
	public static void main(String[] args) {

		// IEEE 754
		double a = 3.0 / 0;
		System.out.println(a);// Infinity
		System.out.println(a + 1);// Infinity
		System.out.println(a + a);// Infinity
		System.out.println(1 / a);// 0.0
		System.out.println(a * -1);// -Infinity
		System.out.println(1 / (-a));// -0.0
		System.out.println(a - a);// NaN
		System.out.println(a / a);// NaN

		double b = 0.0 / 0.0;
		System.out.println(b);//NaN
		System.out.println(b + 12);//NaN:Not a Namber与任何值运算都NaN
		
		//4舍六入5成双
		//1.15:舍去是1.1，入则是1.2。成双，则值为1.2
		
		/*
		 * MathContext：2参数，1保留多少位，2舍入模式
		 */
		BigDecimal c=BigDecimal.valueOf(1).divide(BigDecimal.valueOf(5),new MathContext(100));
	}
}
