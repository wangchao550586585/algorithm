
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ����һ��5λ�������磺34256�������ĸ�λ���ִ��ң��������У����Եõ�һ����������65432��
 * һ����С����23456�������������ֵĲ�ã�41976������������ٴ��ظ��������̣��������5λ����ǰ�߲�0����
 * ������������ֻ�����ĳ��ѭ��Ȧ����Ϊ���ֺڶ����� ���磬�ղŵ����ֻ����룺[82962, 75933, 63954, 61974] ���ѭ��Ȧ��
 * ���д�����ҵ�5λ�����п��ܵ�ѭ��Ȧ���������ÿ��ѭ��Ȧռ1�С�����5λ��ȫ����ͬ��ѭ��ȦΪ [0]��������Բ����ǡ�ѭ��Ȧ�������ʽ���գ�
 * [82962, 75933, 63954, 61974]
 * 
 * 65432 23456 41976:97641-14679 82962:98622-22689 75933:97533-33579
 * 63954:96543-34569 61974:97641-14679 82962
 * 
 * @author Administrator
 * 
 */
public class ѭ��Ȧ {
	static Map<Integer, Integer[]> ar = new HashMap<Integer, Integer[]>();// �洢ѭ��Ȧ
	static int[] is;
	static int size = 5;

	public static void main(String[] args) {
		fun();
		display();
	}

	private static void display() {
		Set<Integer> keySet = ar.keySet();
		for (Integer key : keySet) {
			Integer[] result = ar.get(key);
//			System.out.println(key+" "+Arrays.toString(result));
			if(key>=1000&&key<=9999)
			System.out.println(key);
		}

	}

	private static void fun() {
		for (int i = 1; i < 10; i++)
			for (int k = 0; k < 10; k++)
				for (int j = 0; j < 10; j++)
					for (int l = 0; l < 10; l++)
						for (int y = 0; y < 10; y++) {
							if (i == k && k == j && j == l && l == y)
								continue;
							int key = getMaxNumber(i + "" + k + "" + j + "" + l
									+ "" + y);
							Integer[] result = ar.get(key);
							if (result != null)
								continue;
							operation(key);
						}

	}

	private static void operation(int key) {
		Integer[] temp = new Integer[16];
		int temItems = 0;
		String str = key + "";
		int result = 0;
		c: for (int i = 0; i < 16; i++) {
			str = cover(str);
			int max = getMaxNumber(str);
			int min = getMinNumber(max + "");
			result = max - min;
			for (int k = 0; k < temItems-1; k++) {
				if (temp[k] == result){
//					temp[temItems++] = result;
					break c;
				}
			}
			temp[temItems++] = result;
			str = result + "";
		}
		ar.put(key, temp);
	}

	private static int getMaxNumber(String str) {
		str = getMinNumber(str) + "";
		return Integer.parseInt(new StringBuffer(str).reverse().toString());
	}

	private static String cover(String result) {
		int leng;
		if ((leng = 5 - result.length()) != 0) {
			for (int i = 0; i < leng; i++) {
				result = "0" + result;
			}
		}
		return result;

	}

	private static int getMinNumber(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		String s = new String(charArray);
		return Integer.parseInt(s);
	}

}
