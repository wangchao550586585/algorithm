package 中级.浮点数;

/**
 * 一群海盗(<=20人)，打开一瓶酒，所有人平分喝下，倒下几个人。在打开一瓶酒，平均分下倒下几个人，分四次后，大家都倒下了。最后一个倒下的人喝了1瓶酒
 * 
 * @author Administrator
 * 
 */
public class B_海盗分酒 {
	public static void main(String[] args) {
		for (int i = 20; i >= 1; i--)
			for (int j = i - 1; j >= 1; j--)
				for (int k = j - 1; k >= 1; k--)
					for (int n = k - 1; n >= 1; n--) {
						/*
						 * 浮点数有时存在不精确问题
						 * 
						 * @1误差范围内允许相等：
						 * 
						 * @2:同分,化整数
						 */
//						if (1.0 / i + 1.0 / j + 1.0 / k + 1.0 / n == 1.0)
//							if (Math.abs(1.0 / i + 1.0 / j + 1.0 / k + 1.0 / n
//									- 1.0) < 1E-10)
								if (j * k * n + i * k * n + i * j * n + i * j
										* k == i * j * k * n) {
									System.out.println(i + " " + j + " " + k
											+ " " + n);
								}
					}
	}
}
