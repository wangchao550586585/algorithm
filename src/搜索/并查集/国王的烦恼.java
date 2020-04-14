package 搜索.并查集;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 国王的烦恼 {
	static class Edge {
		public int to;
		public int next;
		public int day;

		public Edge(int to, int next, int day) {
			super();
			this.to = to;
			this.next = next;
			this.day = day;
		}

	}

	static Edge[] edge;
	static int pre[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		edge = new Edge[m];
		pre = new int[n + 1];
		for (int i = 0; i <= n; i++)
			pre[i] = i;
		for (int i = 0; i < m; i++) {
			edge[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(edge, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o2.day - o1.day;
			}
		});
		int lastDay = -1;
		int count = 0;
		int visited = 0;
		for (int i = 0; i < m; i++) {
			if (union(edge[i].to, edge[i].next)) {
				if (lastDay != edge[i].day) {
					lastDay = edge[i].day;
					count++;
				}
				visited++;
			}
			if (visited == n - 1)
				break;
		}
		System.out.println(count);
	}

	private static boolean union(int to, int next) {
		int x = find(to);
		int y = find(next);
		if (x != y) {
			pre[x] = y;
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
