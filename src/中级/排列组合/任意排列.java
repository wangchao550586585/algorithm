package 中级.排列组合;

import java.util.ArrayList;
import java.util.Arrays;

public class 任意排列 {
	public static void main(String[] args) {
		Object[] arr = { 1, 2, 3, 4, 5 };
		ArrayList<Object[]> arrList = random(arr);
		for (Object[] ob : arrList) {
			System.out.println(Arrays.toString(ob));
		}

	}

	/**
	 * 任意排列
	 * 
	 * @param source
	 * @return
	 */
	private static ArrayList<Object[]> random(Object[] source) {
		ArrayList<Object[]> result = new ArrayList<Object[]>();
		if (source.length == 1) {
			result.add(source);
		} else {
			Object[] nSource = new Object[source.length - 1];
			for (int i = 0; i < nSource.length; i++) {
				nSource[i] = source[i];
			}
			result = random(nSource);
			int size = result.size();
			result.add(new Object[] { source[source.length - 1] });
			for (int i = 0; i < size; i++) {
				Object[] temp = new Object[result.get(i).length + 1];
				for (int k = 0; k < temp.length - 1; k++) {
					temp[k] = result.get(i)[k];
				}
				temp[temp.length - 1] = source[source.length - 1];
				result.add(temp);

			}

		}
		return result;
	}
}
