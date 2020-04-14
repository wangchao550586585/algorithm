package 贪心;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class 盾神与积木游戏 {

	private static InputStream is = System.in;

	public static int nextInt() {
		try {
			int i;

			while ((i = is.read()) < 45 || i > 57) {
			}

			int mark = 1, temp = 0;

			if (i == 45) {
				mark = -1;
				i = is.read();
			}

			while (i > 47 && i < 58) {
				temp = temp * 10 + i - 48;
				i = is.read();
			}

			return temp * mark;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return -1;
	}

	static class Item {
		public int have;
		public int need;

		public Item(int have, int need) {
			this.have = have;
			this.need = need - have;
		}

	}

	public static void main(String[] args) {
		int n = nextInt();
		while (n-- > 0) {
			int m = nextInt();
			Item[] item = new Item[m];
			for (int i = 0; i < m; i++) {
				item[i] = new Item(nextInt(), nextInt());
			}
			Arrays.sort(item, new Comparator<Item>() {
				public int compare(Item o1, Item o2) {
					return o1.need - o2.need;
				}
			});
			if (item[0].need > 0) {
				System.out.println("NO");
				continue;
			}
			int currentHave = item[0].have;
			String result = "YES";
			for (int i = 1; i < m; i++) {
				if (item[i].need <= 0) {
					currentHave += item[i].have;
				} else {
					if (item[i].need <= currentHave) {
						currentHave += item[i].have;
					} else {
						result = "NO";
						break;
					}
				}
			}
			System.out.println(result);
		}
	}
}
