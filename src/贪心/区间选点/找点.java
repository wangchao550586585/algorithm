package ̰��.����ѡ��;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * ����ѡ�㣬����end��С��������
 * ע�⣬Ҫ��������Ҫ������������start��endȡֵ��ΧΪ0��
 * int num = item[0].end;// start��endȡֵ��ΧΪ(0��a��b��100��,���в���ȡ0
 * ����Ҫѡ���ٵĵ㣬ÿ�λ�ȡ����end�����ɡ�
 */
public class �ҵ� {
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
			int num = item[0].end;// start��endȡֵ��ΧΪ(0��a��b��100��,���в���ȡ0
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
