package 搜索;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 深搜，
 * 广搜，
 * 新算法
 * 数据结构：链式前向星|链表|数组
 * 获取上一个城市编号即可
 */
public class 吝啬的国度_链式前向星 {
	static class Edge {
		public int to;
		public int next;
	}

	static int top;
	static int[] head;
	static Edge[] edge;
	static int result[];
	static boolean visited[];
	static int m;
	static int s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			m = sc.nextInt();
			s = sc.nextInt();
			init();
			int i, j, a, b;
			for (i = 0; i < m - 1; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				addEdge(a, b);
				addEdge(b, a);
			}
			visited[s] = true;
			bfs();
			dfs(s);
			result[s] = -1;
			for (i = 1; i <= m; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}

	private static void dfs(int index) {
		for (int i = head[index]; i != -1; i = edge[i].next) {
			int to = edge[i].to;
			if (!visited[to]) {
				visited[to] = true;
				dfs(to);
			}
			result[to] = index;
		}
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(s);

		while (!que.isEmpty()) {
			int poll = que.poll();
			for (int i = head[poll]; i != -1; i = edge[i].next) {
				int to = edge[i].to;
				if (!visited[to]) {
					result[to] = poll;
					visited[to] = true;
					que.add(to);
				}
			}
		}
	}

	private static void addEdge(int b, int a) {
		edge[top] = new Edge();
		edge[top].to = a;
		edge[top].next = head[b];
		head[b] = top++;
	}

	private static void init() {
		head = new int[2 * (m - 1)];
		edge = new Edge[2 * (m - 1)];
		top = 0;
		Arrays.fill(head, -1);
		result = new int[m + 1];
		visited = new boolean[m + 1];
	}
}
