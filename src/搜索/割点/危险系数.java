package ËÑË÷.¸îµã;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Î£ÏÕÏµÊý {
	static BufferedInputStream bs = new BufferedInputStream(System.in);

	static int readInt() throws IOException {
		int num = 0;
		int i = 0;
		boolean flag = false;
		while (((i = bs.read()) & 48) != 48 || i > 57) {
			if (i == 45)
				flag = true;
		}
		while ((i & 56) == 48 || (i & 62) == 56) {
			num = num * 10 + (i & 15);
			i = bs.read();
		}
		if (flag)
			num = -num;
		return num;
	}

	static class Edge {
		public int to;
		public int next;
	}

	static int head[];
	static Edge[] edge;
	static int top;
	static boolean flag[];
	static int n;
	static int m;
	static int cnt[];
	static int way[];
	static int sum;

	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		cnt = new int[n + 1];
		way = new int[n + 1];
		flag = new boolean[n + 1];
		edge = new Edge[m * 2];
		head = new int[m * 2];
		Arrays.fill(head, -1);
		for (int i = 0; i < m; i++) {
			int u = readInt();
			int v = readInt();
			addEdge(u, v);
			addEdge(v, u);
		}

		dfs(readInt(), readInt(), 0);
		operation();

	}

	private static void operation() {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (cnt[i] == sum)
				result++;
		}
		System.out.println(result - 2);
	}

	private static void dfs(int u, int v, int count) {
		flag[u] = true;
		way[count] = u;
		if (u == v) {
			sum++;
			for (int i = 0; i <= count; i++) {
				cnt[way[i]]++;
			}
		} else {
			for (int i = head[u]; i != -1; i = edge[i].next) {
				int to = edge[i].to;
				if (!flag[to]) {
					dfs(to, v, count + 1);
					//	flag[u] = false;
				}
			}
		}
		flag[u] = false;
	}

	private static void addEdge(int u, int v) {
		edge[top] = new Edge();
		edge[top].to = v;
		edge[top].next = head[u];
		head[u] = top++;

	}
}
