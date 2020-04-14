package 搜索.并查集;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 城市建设 {
	static class Edge {
		public int to;
		public int next;
		public int price;

		public Edge(int to, int next, int price) {
			super();
			this.to = to;
			this.next = next;
			this.price = price;
		}

	}

	static Edge[] edge;
	static int[] pre;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		edge = new Edge[m + n];
		pre = new int[n + 1];
		for (int i = 0; i < m; i++) {
			edge[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int count = 0;

		for (int i = 1; i <= n; i++) {
			int price = sc.nextInt();
			if (price != -1) {
				edge[m + count] = new Edge(0, i, price);
				count++;
			}
		}
		int result1 = dfs(n, m);
		int result2 = dfs(n + 1, m + count);
		if (result1 != -1) {
			result2 = Math.min(result1, result2);
		}
		System.out.println(result2);

	}

	private static int dfs(int n, int m) {
		init(m);
		int maxPrice = 0;
		int count = 0;
		for (int i = 0; i < m; i++) {
			if (union(edge[i].to, edge[i].next)) {
				maxPrice += (edge[i].price);
				count++;
			} else if (edge[i].price < 0) {
				maxPrice -= 1;
			}
		}
		if (count != n - 1)
			return -1;
		return maxPrice;
	}

	private static void init(int m) {
		for (int i = 0; i <= n; i++)
			pre[i] = i;
		Arrays.sort(edge, 0, m, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o1.price - o2.price;
			}
		});
	}

	private static boolean union(int to, int next) {
		int x = find(to);
		int y = find(next);
		if (x != y) {
			pre[x] = pre[y];
			return true;
		}
		return false;
	}

	private static int find(int to) {

		int root = to;
		while (root != pre[root]) {
			root = pre[root];
		}
		int temp;
		while (to != root) {
			temp = pre[to];
			pre[to] = root;
			to = temp;
		}
		return root;
	}
}
