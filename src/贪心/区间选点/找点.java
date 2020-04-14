package 贪心.区间选点;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 区间选点，果断end从小到大排序，
 * 注意，要排序，排序要给出排序函数，start和end取值范围为0，
 * int num = item[0].end;// start和end取值范围为(0≤a≤b≤100）,所有不能取0
 * 由于要选最少的点，每次获取最大的end，即可。
 */
public class 找点 {
	static class Item {
		public int start;
		public int end;

		public Item(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

	static Comparator<Item> c = new Comparator<Item>() {
		public int compare(Item o1, Item o2) {
			return o1.end - o2.end;
		}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			Item[] item = new Item[m];
			for (int i = 0; i < m; i++) {
				item[i] = new Item(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(item, c);
			int num = item[0].end;// start和end取值范围为(0≤a≤b≤100）,所有不能取0
			int result = 1;
			for (int i = 1; i < m; i++) {
				if (item[i].start > num) {
					num = item[i].end;
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
