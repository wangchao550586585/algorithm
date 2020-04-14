package 中级.随机算法;

import java.util.Scanner;
import java.util.Stack;

/**
 * @:1：点数1-10中，抽取4张牌，
 * @:2:+-(*)/后结果正好24
 * 随机是稳定模型，因为它随机扰动，所以它抗扰动。
 */
public class B_4张牌4则结果24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入4整数：");
			String[] arr = sc.nextLine().split(" +");
			f(arr);
		}
	}

	/**
	 * 随机产生组合方式
	 * 
	 * @param arr
	 */
	private static void f(String[] arr) {
		/*
		 * @ 第一个for：组合次数
		 * 
		 * @ 第二个for：数组填值
		 * 
		 * @ 第三个for：数组填运算符号
		 * 
		 * @ 打乱
		 * 
		 * @ 运算，判断是否得24
		 * 
		 * @ 最后利用后缀表达式(逆波兰表 达式)算出式子是否得24
		 */
		String[] st;
		for (int i = 0; i < 10000 * 100; i++) {
			st = new String[7];
			for (int k = 0; k < 4; k++)
				st[k] = arr[k];
			for (int j = 4; j < 7; j++)
				st[j] = random_op();
			shuffle(st);
			if (compute(st)) {
				show(st);
				break;// 只显示一次
			}
		}

	}

	/**
	 * 显示
	 * 
	 * @param st
	 */
	private static void show(String[] buf) {
		Stack<String> s = new Stack<String>();

		char c;
		for (int i = 0; i < buf.length; i++) {
			c = buf[i].charAt(0);
			if (c >= '0' && c <= '9') {
				s.push(buf[i]);
			} else {
				switch (c) {
				case '+':
				case '-':
				case '*':
				case '/':
					s.push("(" + s.pop() + buf[i] + s.pop() + ")");
					break;
				}
			}
		}
		System.out.println(s.pop());
	}

	/**
	 * 使用逆波兰表达式运算
	 * 
	 * @param st
	 * @return
	 */
	private static boolean compute(String[] buf) {
		Stack<String> s = new Stack<String>();

		char c;
		int num1, num2, result = 0;
		try {
			for (int i = 0; i < buf.length; i++) {
				c = buf[i].charAt(0);
				if (c >= '0' && c <= '9') {
					s.push(buf[i]);
				} else {
					num1 = Integer.parseInt(s.pop());
					num2 = Integer.parseInt(s.pop());
					switch (c) {
					case '+':
						result = num1 + num2;
						break;
					case '-':
						result = num1 - num2;
						break;
					case '*':
						result = num1 * num2;
						break;
					case '/':
						if (num1 % num2 != 0)
							throw new Exception();
						result = num1 / num2;
						break;
					}
					s.push(result + "");
				}
			}
		} catch (Exception e) {
			return false;
		}
		return s.size() == 1 && s.pop().equals("24");
	}

	/**
	 * 打乱
	 * 
	 * @param st
	 */
	private static void shuffle(String[] st) {
		int n;
		String temp;
		for (int i = 0; i < st.length; i++) {
			n = (int) (Math.random() * st.length);
			temp = st[i];
			st[i] = st[n];
			st[n] = temp;
		}

	}

	/**
	 * 返回运算符号
	 * 
	 * @return
	 */
	private static String random_op() {
		int n = (int) (Math.random() * 4);
		if (n == 0)
			return "+";
		if (n == 1)
			return "-";
		if (n == 2)
			return "*";
		return "/";
	}
}
