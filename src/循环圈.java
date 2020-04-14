
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 任意一个5位数，比如：34256，把它的各位数字打乱，重新排列，可以得到一个最大的数：65432，
 * 一个最小的数23456。求这两个数字的差，得：41976，把这个数字再次重复上述过程（如果不足5位，则前边补0）。
 * 如此往复，数字会落入某个循环圈（称为数字黑洞）。 比如，刚才的数字会落入：[82962, 75933, 63954, 61974] 这个循环圈。
 * 请编写程序，找到5位数所有可能的循环圈，并输出，每个循环圈占1行。其中5位数全都相同则循环圈为 [0]，这个可以不考虑。循环圈的输出格式仿照：
 * [82962, 75933, 63954, 61974]
 * 
 * 65432 23456 41976:97641-14679 82962:98622-22689 75933:97533-33579
 * 63954:96543-34569 61974:97641-14679 82962
 * 
 * @author Administrator
 * 
 */
public class 循环圈 {
	static Map<Integer, Integer[]> ar = new HashMap<Integer, Integer[]>();// 存储循环圈
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
