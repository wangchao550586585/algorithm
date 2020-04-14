package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 背包问题 {
	static class Item {
		public int v;
		public int w;

		public Item(int v, int w) {
			this.v = v;
			this.w = w;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int s = sc.nextInt();
			int m = sc.nextInt();
			Item[] items = new Item[s];
			for (int i = 0; i < s; i++) {
				items[i] = new Item(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(items, new Comparator<Item>() {
				public int compare(Item o1, Item o2) {
					return o2.v - o1.v;
				}
			});
			int result = 0;
			for (int i = 0; i < s; i++) {
				if (m <= items[i].w) {
					result += (m * items[i].v);
					break;
				} else {
					result += (items[i].v * items[i].w);
					m -= items[i].w;
				}
			}
			System.out.println(result);
		}
	}
}
