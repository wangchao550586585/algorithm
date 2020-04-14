package 中级.递归;

/**
 * 明细n个组合，去掉的数字总和=6，不去掉的显示
 * 
 * @author Administrator
 * 
 */
public class 查帐 {

	static int err_sum = 6;// 错误金额
	static int[] arr = { 3, 2, 4, 3, 1 };// 明细

	public static void main(String[] args) {
		fun(0, 0, new boolean[arr.length]);

	}

	/**
	 * @param k 当前处理位置 
	 * @param cur_sum 前面数字累加和
	 * @param b	表示arr对应项是否选取
	 */
	private static void fun(int k, int cur_sum, boolean[] b) {
		/*
		 * 出口
		 * 1:超过错误项，取多了
		 * 2：得到结果，输出,放在中间，只为了防止刚好到了数组最后一项，返回。
		 * 3：超出数组长度，也就说明到了最后一项
		 */
		if(cur_sum>err_sum)return;
		if(err_sum==cur_sum){
			for(int i=0;i<b.length;i++)
				if(b[i]==false)
					System.out.print(arr[i]+" ");
			System.out.println();
			return ;
		}
		if(k>=arr.length)return;
		
		/*
		 * 1:不取
		 * 2：取
		 * 3:回溯
		 */
		b[k]=false;
		fun(k+1,cur_sum,b);
		
		b[k]=true;
		fun(k+1,cur_sum+=arr[k],b);
		
		b[k]=false;
		
		
	}
}
