package 搜索.并查集;
import java.util.Scanner;

/*
 * 先用并查集，判断图是否连通，
 * 然后在利用欧拉图的特性，
 * 注意:如果并查集的union是利用x和y的大小进行赋值的话，最后会有一个共同值，最大，或者最小
 * 如果不是的话，值会不确定。
 * 
 *\\\\\\\\
 * 一笔画 即线路不能中断，不能画重复线路 
 * 能否一笔画成，关键在于判别奇点、偶点的个数。  
 * ：：只有偶点，可以一笔画，并且可以以任意一点作为起点 
 * ：：只有两个奇点，可以一笔画，但必须以这两个奇点分别作为起点和终点。 
 * ：：奇点超过两个，则不能一笔画。 
 * 对于一些比较复杂的路线问题，可以先转化为简单的几何图形，然后根据判定是否能一笔画的方法进行解答。 
 * 如果有限连通图 G 有 2k 个奇顶点，那么它可以用 k 笔画成，并且至少要用 k 笔画成[2]。 
 * \\\\\\\\\\
 * 一笔画问题，也就是欧拉道路，这一题，简单的欧拉回路的应用。
什么是欧拉回路？
欧拉回路就是在图A中，存在一条路径使得每一条边都走过一次，并且这条路径是一个圈，就是欧拉回路。
欧拉回路的判断：
1.在有向图中：首先必要的条件是图连通，所以顶点的入度都等于出度。
2.在无向图中：首要条件还是图连通，其次就是所以顶点都是偶数度（该顶点的度为偶数）
这一题，还需要加上一个条件，也就是存在两个奇数度的点的情况，也是符合的，从一个奇数点出发，另外一个奇数点结束。
 */

public class 一笔画 {
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

			/*这种方式，要保证union函数是利用大小赋值的。
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
			// 利用顶点的值肯定是自己特性，算出有几个顶点是自己，说明一个图有不同的顶点，也就是不连通
			a = 0;
			for (int i = 1; i <= p; i++) {
				if (pre[i] == i)
					a++;
			}
			if (a > 1)
				System.out.println("No");
			else {
				/*			错误1	,应该算出每一个点被引用，也就是单顶点的数量
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
