package 贪心.区间选点;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 开启和关闭为一次，区间选点
 * 区间选点，选的点最少，那么按照right进行排序，只要是<--right这个范围内的，都看做一个点，不在范围的看做另外一个点
 */
public class 非洲小孩 {

	static class Item {
		public int start;
		public int end;

		public Item(int have, int need) {
			this.start = have;
			this.end = need;
		}

		@Override
		public String toString() {
			return "Item [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Item[] item = new Item[n];
			for (int i = 0; i < n; i++) {
				char[] c = sc.next().toCharArray();
				int start = ((c[0] - '0') * 10 + (c[1] - '0')) * 60
						+ (c[3] - '0') * 10 + (c[4] - '0');
				int end = ((c[6] - '0') * 10 + (c[7] - '0')) * 60
						+ (c[9] - '0') * 10 + (c[10] - '0');
				if (start > end) {
					start = start ^ end;
					end = end ^ start;
					start = start ^ end;
					/*
					int temp = start;
					start = end;
					end = temp;*/
				}
				item[i] = new Item(start, end);
			}
			Arrays.sort(item, new Comparator<Item>() {
				public int compare(Item o1, Item o2) {
					return o1.end - o2.end;
				}
			});
			int count = 1;
			int re = item[0].end;
			for (int i = 1; i < n; i++) {
				if (item[i].start > re) {
					re = item[i].end;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
