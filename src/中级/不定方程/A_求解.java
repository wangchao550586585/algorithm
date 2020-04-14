package 中级.不定方程;

public class A_求解 {
	public static void main(String[] args) {
		/*
		 * 4*x-5*y=7
		 */
		// 方式1：暴力破解：针对大型数字无力
		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++)
				if (4 * x - 5 * y == 7)
					System.out.println(x + " " + y);
		/*
		 * 
		 * @:方式2:求出一个特殊解
		 * 
		 * @： a=4,b=-5,c=7
		 * 
		 * @：ax+by=c
		 * 
		 * @:ax=c-by
		 * 
		 * @:x=(c-by)/a:取模a等于0，说明整除，y值确定
		 */
		for (int y = 0; y < 100; y++) {
			if ((7 - (-5 * y)) % 4 == 0) {
				System.out.print(y + " ");
				System.out.println((7 - (-5 * y)) / 4);
				break;
			}
		}
		/*
		 * 方式三：求通解
		 * @:ax+by=c
		 * @:x=x+bt
		 * @:y=y-at
		 * @:a(x+bt)+b(y-at)=c,t取整数
		 */
	}
}
