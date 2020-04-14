package 搜索.并查集;
import java.util.Scanner;

/*
 * 1:使用num算出总的合并次数。
 * 5个点，最少要保证合并5-1次才能保证图连通
 * num<n-1;不连通
 * num+1<n
 * n-num>1
 */
public class 一笔画优化 {
	static int[] pre;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			pre = new int[p + 1];
			int arr[] = new int[p + 1];
			for (int i = 1; i <= p; i++)
				pre[i] = i;
			int a, b;
			int num = 0;// 优化1
			for (int i = 0; i < q; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				arr[a]++;
				arr[b]++;
				int x = find(a);
				int y = find(b);
				if (x != y) {
					pre[x] = y;
					num++;
				}
			}

			if (p - num > 1)
				System.out.println("No");
			else {
				num = 0;
				for (int i = 1; i <= p; i++) {
					if (num > 2)// 优化2
						break;
					num += (arr[i] % 2);
				}
				if (num == 0 || num == 2) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

	private static int find(int a) {//优化3
		if (a == pre[a])
			return a;
		return pre[a] = find(pre[a]);
	}

}
