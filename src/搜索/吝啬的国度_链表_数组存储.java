package 搜索;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 吝啬的国度_链表_数组存储 {
	static class Edge {
		public int next;
		public Edge e;
	}

	static int result[];
	static boolean visited[];
	static int m;
	static int s;
	static Edge[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			m = sc.nextInt();
			s = sc.nextInt();
			arr = new Edge[m + 1];
			visited = new boolean[m + 1];
			result = new int[m + 1];
			for (int i = 0; i <= m; i++) {
				arr[i] = null;
			}
			int i, a, b;
			Edge edge;
			for (i = 0; i < m - 1; i++) {
				a = sc.nextInt();
				b = sc.nextInt();

				edge = new Edge();
				edge.next = b;
				edge.e = arr[a];
				arr[a] = edge;

				edge = new Edge();
				edge.next = a;
				edge.e = arr[b];
				arr[b] = edge;
			}

			visited[s] = true;
			dfs(s);
			bfs();
			result[s] = -1;
			for (i = 1; i <= m; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(s);
		while (!que.isEmpty()) {
			Integer poll = que.poll();
			Edge edge = arr[poll];
			while (edge != null) {
				int next = edge.next;
				if (!visited[next]) {
					visited[next] = true;
					result[next] = poll;
					que.add(next);
				}
				edge = edge.e;
			}
		}

	}

	private static void dfs(int s) {
		Edge edge = arr[s];
		while (edge != null) {
			int next = edge.next;
			if (!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
			result[next] = s;
			edge = edge.e;
		}

	}
}
