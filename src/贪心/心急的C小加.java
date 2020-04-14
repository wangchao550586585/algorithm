package ̰��;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * �����i+1��ľ���������ͳ��ȶ����ڵ��ڵ�i�������ľ������ô������ķ�ʱ�䣬
 * ľ��������С���������������ʱ���ճ��ȴ�С��������
 */
public class �ļ���CС�� {
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
				if (item[i].w > 0) {//ʹ�������Ϊ0���м�֦
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
