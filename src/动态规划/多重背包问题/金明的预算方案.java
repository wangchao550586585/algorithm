package 动态规划.多重背包问题;


import java.util.Scanner;

/*
 * 金明今天很开心，家里购置的新房就要领钥匙了，新房里有一间金明自己专用的很宽敞的房间。更让他高兴的是，妈妈昨天对他说：“你的房间需要购买哪些物品，怎么布置，你说了算，只要不超过N元钱就行”。今天一早，金明就开始做预算了，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 主件	附件
 电脑	打印机，扫描仪
 书柜	图书
 书桌	台灯，文具
 工作椅	无

 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有0个、1个或2个附件。附件不再有从属于自己的附件。
 金明想买的东西很多，肯定会超过妈妈限定的N元。于是，他把每件物品规定了一个重要度，分为5等：用整数1~5表示，第5等最重要。
 他还从因特网上查到了每件物品的价格（都是10元的整数倍）。他希望在不超过N元（可以等于N元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 设第j件物品的价格为v[j]，重要度为w[j]，共选中了k件物品，编号依次为j_1，j_2，……，j_k，则所求的总和为：
 v[j_1]*w[j_1]+v[j_2]*w[j_2]+ …+v[j_k]*w[j_k]。（其中*为乘号）
 请你帮助金明设计一个满足要求的购物单。
 输入格式
 输入文件budget.in 的第1行，为两个正整数，用一个空格隔开：
 N m
 （其中N（<32000）表示总钱数，m（<60）为希望购买物品的个数。）
 从第2行到第m+1行，第j行给出了编号为j-1的物品的基本数据，每行有3个非负整数
 v p q
 （其中v表示该物品的价格（v<10000），p表示该物品的重要度（1~5），q表示该物品是主件还是附件。如果q=0，表示该物品为主件，如果q>0，表示该物品为附件，q是所属主件的编号）
 输出格式
 输出文件budget.out只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（<200000）。
 样例输入
 1000 5
 800 2 0
 400 5 1
 300 5 1
 400 3 0
 500 2 0
 样例输出
 2200

 */
public class 金明的预算方案 {
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
				// 这里之所有从后往前，是为了防止从前往后后，后面的引用了前面的数据
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
