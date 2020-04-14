package ��̬�滮.���ر�������;


import java.util.Scanner;

/*
 * ��������ܿ��ģ����ﹺ�õ��·���Ҫ��Կ���ˣ��·�����һ������Լ�ר�õĺܿ��ķ��䡣���������˵��ǣ������������˵������ķ�����Ҫ������Щ��Ʒ����ô���ã���˵���㣬ֻҪ������NԪǮ���С�������һ�磬�����Ϳ�ʼ��Ԥ���ˣ������������Ʒ��Ϊ���ࣺ�����븽���������Ǵ�����ĳ�������ģ��±����һЩ�����븽�������ӣ�
 ����	����
 ����	��ӡ����ɨ����
 ���	ͼ��
 ����	̨�ƣ��ľ�
 ������	��

 ���Ҫ�����Ϊ��������Ʒ����������ø���������������ÿ������������0����1����2�����������������д������Լ��ĸ�����
 ��������Ķ����ܶ࣬�϶��ᳬ�������޶���NԪ�����ǣ�����ÿ����Ʒ�涨��һ����Ҫ�ȣ���Ϊ5�ȣ�������1~5��ʾ����5������Ҫ��
 �������������ϲ鵽��ÿ����Ʒ�ļ۸񣨶���10Ԫ��������������ϣ���ڲ�����NԪ�����Ե���NԪ����ǰ���£�ʹÿ����Ʒ�ļ۸�����Ҫ�ȵĳ˻����ܺ����
 ���j����Ʒ�ļ۸�Ϊv[j]����Ҫ��Ϊw[j]����ѡ����k����Ʒ���������Ϊj_1��j_2��������j_k����������ܺ�Ϊ��
 v[j_1]*w[j_1]+v[j_2]*w[j_2]+ ��+v[j_k]*w[j_k]��������*Ϊ�˺ţ�
 ��������������һ������Ҫ��Ĺ��ﵥ��
 �����ʽ
 �����ļ�budget.in �ĵ�1�У�Ϊ��������������һ���ո������
 N m
 ������N��<32000����ʾ��Ǯ����m��<60��Ϊϣ��������Ʒ�ĸ�������
 �ӵ�2�е���m+1�У���j�и����˱��Ϊj-1����Ʒ�Ļ������ݣ�ÿ����3���Ǹ�����
 v p q
 ������v��ʾ����Ʒ�ļ۸�v<10000����p��ʾ����Ʒ����Ҫ�ȣ�1~5����q��ʾ����Ʒ���������Ǹ��������q=0����ʾ����ƷΪ���������q>0����ʾ����ƷΪ������q�����������ı�ţ�
 �����ʽ
 ����ļ�budget.outֻ��һ����������Ϊ��������Ǯ������Ʒ�ļ۸�����Ҫ�ȳ˻����ܺ͵����ֵ��<200000����
 ��������
 1000 5
 800 2 0
 400 5 1
 300 5 1
 400 3 0
 500 2 0
 �������
 2200

 */
public class ������Ԥ�㷽�� {
	static class Item {
		public int price;
		public int w;
		public int q;
		public int importance;

		public Item(int price, int w, int q) {
			this.price = price;
			this.w = w;
			this.q = q;
			importance = w * price;
		}

	}

	private static Item[] items;
	private static int sumPrice;
	private static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sumPrice = sc.nextInt();
		count = sc.nextInt();
		items = new Item[count + 1];
		for (int i = 1; i <= count; i++) {
			items[i] = new Item(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int result[] = new int[sumPrice + 1];
		for (int i = 1; i <= count; i++) {
			if (items[i].q == 0) {
				boolean flag1 = false, flag2 = false;
				int a = 0, b = 0;
				for (int k = 1; k <= count; k++) {
					if (items[k].q == i) {
						flag1 = true;
						a = k;
						break;
					}
				}
				for (int k = a + 1; k <= count; k++) {
					if (items[k].q == i) {
						flag2 = true;
						b = k;
						break;
					}
				}
				// ����֮���дӺ���ǰ����Ϊ�˷�ֹ��ǰ����󣬺����������ǰ�������
				for (int s = sumPrice; s >= items[i].price; s = s - 10) {
					result[s] = Math.max(result[s - items[i].price]
							+ items[i].importance, result[s]);
					if (flag1 && s - items[a].price - items[i].price >= 0) {
						result[s] = Math.max(result[s], result[s
								- items[a].price - items[i].price]
								+ items[a].importance + items[i].importance);
					}
					if (flag2 && s - items[b].price - items[i].price >= 0) {
						result[s] = Math.max(result[s], result[s
								- items[b].price - items[i].price]
								+ items[b].importance + items[i].importance);

					}
					if (flag1
							&& flag2
							&& s - items[a].price - items[b].price
									- items[i].price >= 0) {
						result[s] = Math.max(result[s], result[s
								- items[b].price - items[a].price
								- items[i].price]
								+ items[b].importance
								+ items[a].importance
								+ items[i].importance);
					}
				}
			}

		}
		System.out.println(result[sumPrice]);

	}
}
