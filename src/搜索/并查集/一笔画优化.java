package ����.���鼯;
import java.util.Scanner;

/*
 * 1:ʹ��num����ܵĺϲ�������
 * 5���㣬����Ҫ��֤�ϲ�5-1�β��ܱ�֤ͼ��ͨ
 * num<n-1;����ͨ
 * num+1<n
 * n-num>1
 */
public class һ�ʻ��Ż� {
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
			int num = 0;// �Ż�1
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
					if (num > 2)// �Ż�2
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

	private static int find(int a) {//�Ż�3
		if (a == pre[a])
			return a;
		return pre[a] = find(pre[a]);
	}

}
