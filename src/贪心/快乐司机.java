package 贪心;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 快乐司机 {
	static class Item {
		public int gi;
		public int pi;
		public double s;

		public Item(int gi, int pi) {
			this.gi = gi;
			this.pi = pi;
			this.s = pi * 1.0 / gi;
		}

		@Override
		public String toString() {
			return "Item [gi=" + gi + ", pi=" + pi + ", s=" + s + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		Item[] items = new Item[n];
		for (int i = 0; i < n; i++) {
			items[i] = new Item(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(items, new Comparator<Item>() {
			public int compare(Item o1, Item o2) {
				return Double.compare(o2.s, o1.s);
			}
		});
		System.out.println(Arrays.toString(items));
		double priceSum = 0;
		for (int i = 0; i < n; i++) {
			if (w >= items[i].gi) {
				w -= items[i].gi;
				priceSum += items[i].pi;
			} else {
				priceSum += (w * items[i].s);
				break;
			}
		}
		System.out.println(new DecimalFormat("#.0").format(priceSum));
		System.out.printf("%.1f", priceSum);

	}
}
