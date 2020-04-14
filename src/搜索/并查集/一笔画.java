package ����.���鼯;
import java.util.Scanner;

/*
 * ���ò��鼯���ж�ͼ�Ƿ���ͨ��
 * Ȼ��������ŷ��ͼ�����ԣ�
 * ע��:������鼯��union������x��y�Ĵ�С���и�ֵ�Ļ���������һ����ֵͬ����󣬻�����С
 * ������ǵĻ���ֵ�᲻ȷ����
 * 
 *\\\\\\\\
 * һ�ʻ� ����·�����жϣ����ܻ��ظ���· 
 * �ܷ�һ�ʻ��ɣ��ؼ������б���㡢ż��ĸ�����  
 * ����ֻ��ż�㣬����һ�ʻ������ҿ���������һ����Ϊ��� 
 * ����ֻ��������㣬����һ�ʻ��������������������ֱ���Ϊ�����յ㡣 
 * ������㳬������������һ�ʻ��� 
 * ����һЩ�Ƚϸ��ӵ�·�����⣬������ת��Ϊ�򵥵ļ���ͼ�Σ�Ȼ������ж��Ƿ���һ�ʻ��ķ������н�� 
 * ���������ͨͼ G �� 2k ���涥�㣬��ô�������� k �ʻ��ɣ���������Ҫ�� k �ʻ���[2]�� 
 * \\\\\\\\\\
 * һ�ʻ����⣬Ҳ����ŷ����·����һ�⣬�򵥵�ŷ����·��Ӧ�á�
ʲô��ŷ����·��
ŷ����·������ͼA�У�����һ��·��ʹ��ÿһ���߶��߹�һ�Σ���������·����һ��Ȧ������ŷ����·��
ŷ����·���жϣ�
1.������ͼ�У����ȱ�Ҫ��������ͼ��ͨ�����Զ������ȶ����ڳ��ȡ�
2.������ͼ�У���Ҫ��������ͼ��ͨ����ξ������Զ��㶼��ż���ȣ��ö���Ķ�Ϊż����
��һ�⣬����Ҫ����һ��������Ҳ���Ǵ������������ȵĵ�������Ҳ�Ƿ��ϵģ���һ�����������������һ�������������
 */

public class һ�ʻ� {
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
			for (int i = 0; i < q; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				arr[a]++;
				arr[b]++;
				union(a, b);
			}

			/*���ַ�ʽ��Ҫ��֤union���������ô�С��ֵ�ġ�
			 * a = pre[1];
			boolean flag = true;
			System.out.println(Arrays.toString(pre));
			for (int i = 2; i <= p; i++) {
				if (pre[i] != a) {
					System.out.println(pre[i]+" "+a);
					flag = false;
					break;
				}
			}
			if (!flag) {
				System.out.println("No");
			}*/
			// ���ö����ֵ�϶����Լ����ԣ�����м����������Լ���˵��һ��ͼ�в�ͬ�Ķ��㣬Ҳ���ǲ���ͨ
			a = 0;
			for (int i = 1; i <= p; i++) {
				if (pre[i] == i)
					a++;
			}
			if (a > 1)
				System.out.println("No");
			else {
				/*			����1	,Ӧ�����ÿһ���㱻���ã�Ҳ���ǵ����������
				 * for (int i = 1; i <= p; i++) {
									a += arr[i];
								}
								a %= 2;
				*/
				a = 0;
				for (int i = 1; i <= p; i++) {
					a += (arr[i] % 2);
				}
				if (a == 0 || a == 2) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x != y) {
			pre[x] = y;
		}
	}

	private static int find(int a) {
		int root = a;
		while (root != pre[root]) {
			root = pre[root];
		}
		while (a != root) {
			int temp = pre[a];
			pre[a] = root;
			a = temp;
		}
		return root;
	}

}
