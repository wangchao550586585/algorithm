package 中级.排列组合;

import java.util.ArrayList;
import java.util.Arrays;

public class 选择排列 {
	public static void main(String[] args) {
		Object[] arr = { 1, 2, 3, 4, 5 };
		 ArrayList<Object[]> arrList = fun(arr, 3);
		for (Object[] ob : arrList) {
			System.out.println(Arrays.toString(ob));
		}

	}
	/**
	 * 选择排列
	 * 
	 * @param arr
	 * @param i
	 * @return
	 */
	private static ArrayList<Object[]> fun(Object[] source, int n) {
		ArrayList<Object[]> result = new ArrayList<Object[]>();
		// 解决为1状况
		if (n == 1) {
			for (Object ob : source)
				result.add(new Object[] { ob });
		} else if (n == source.length) {
			result.add(source);
		} else {
			Object[] nSource = new Object[source.length - 1];
			for (int i = 0; i < nSource.length; i++) {
				nSource[i] = source[i];
			}
			result = fun(nSource, n);

			// 排列n-1，后面for循环把source[]最后一个值加入进去
			ArrayList<Object[]> temp = fun(nSource, n - 1);
			for (int i = 0; i < temp.size(); i++) {

				Object[] te = new Object[n];
				for (int k = 0; k < n - 1; k++)
					te[k] = temp.get(i)[k];
				te[n - 1] = source[source.length - 1];
				result.add(te);
			}
		}
		return result;

	}
}
