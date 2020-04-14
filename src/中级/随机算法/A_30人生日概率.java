package 中级.随机算法;

/**
 * 30人，出现生日重复概率多大?
 * 
 * @author Administrator
 * 
 */
public class A_30人生日概率 {

	public static void main(String[] args) {
		final int N = 1000 * 100;// 总实验次数
		int n = 0;// 随机产生数字，碰撞次数
		int[] x;
		int p;
		/*
		 * 1000*100次(N)实验，有多少次(n)30人生日重复(算一次)=n/N
		 */
		for (int i = 0; i < N; i++) {
			x = new int[365];
			for (int j = 0; j < 30; j++) {
				p = (int) (Math.random() * 365);
				if (x[p] == 1) {
					n++;
					break;//出现重复就结束这次测试，无需判断多次
				} else
					x[p] = 1;
			}
		}
		double r = (double) n / N;
		System.out.println(r);
	}
}
