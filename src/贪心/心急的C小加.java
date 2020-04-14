package 贪心;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 如果第i+1个木棒的重量和长度都大于等于第i个处理的木棒，那么将不会耗费时间，
 * 木棒重量从小到大排序，重量相等时候按照长度从小到大排列
 */
public class 心急的C小加 {
	static class Item {
		public int l;
		public int w;

		public Item(int l, int w) {
			this.l = l;
			this.w = w;
		}

	}

	static Comparator<Item> c = new Comparator<Item>() {
		public int compare(Item o1, Item o2) {
			if (o1.l == o2.l)
				return o1.w - o2.w;
			return o1.l - o2.l;
		}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			Item[] item = new Item[m];
			for (int i = 0; i < m; i++) {
				item[i] = new Item(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(item, c);
			int count = 0;
			for (int i = 0; i < m; i++) {
				if (item[i].w > 0) {//使用下面的为0进行剪枝
					count++;
					int w = item[i].w;
					for (int j = i + 1; j < m; j++) {
						if (item[j].w >= w) {
							w = item[j].w;
							item[j].w = 0;
						}
					}
				}
			}
			System.out.println(count);

		}
	}
}
