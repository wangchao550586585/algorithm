package ̰��.����ѡ��;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * �����͹ر�Ϊһ�Σ�����ѡ��
 * ����ѡ�㣬ѡ�ĵ����٣���ô����right��������ֻҪ��<--right�����Χ�ڵģ�������һ���㣬���ڷ�Χ�Ŀ�������һ����
 */
public class ����С�� {

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
