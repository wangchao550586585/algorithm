package ËÑË÷;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ´ó³¼µÄÂÃ·Ñ2 {
	static BufferedInputStream bs = new BufferedInputStream(System.in);
	
	static final int INFINITY = 999999;

	static int readInt() {
		int num = 0;
		int i = 0;
		try {
			while (((i = bs.read()) & 48) != 48 || i > 57)
				;
			while ((i & 56) == 48 || (i & 62) == 56) {
				num = num * 10 + (i & 15);
				i = bs.read();
			}
		} catch (IOException e) {
		}
		return num;
	}

	static class Edge {
		public int to;
		public int next;
		public int distance;
	}

	static Edge[] edge;
	static int[] head;
	static int top;
	static boolean[] flag;
	static int maxDi;
	static int maxIndex;

	public static void main(String[] args) {
		int n = readInt();
		init(n);
		for (int i = 0; i < n - 1; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			addEdge(a, b, c);
			addEdge(b, a, c);
		}
		dfs(1, 0);
		dfs(maxIndex, 0);
		System.out.println(maxDi * (21 + maxDi) / 2);
	}

	private static void dfs(int start, int distance) {
		if (distance > maxDi) {
			maxDi = distance;
			maxIndex = start;
		}
		flag[start] = true;
		for (int i = head[start]; i != -1; i = edge[i].next) {
			int to = edge[i].to;
			int dis = edge[i].distance;
			if (flag[to])
				continue;
			dfs(to, distance + dis);
		}
		flag[start] = false;

	}

	private static void init(int n) {
		flag = new boolean[n + 1];
		edge = new Edge[(n - 1) * 2];
		head = new int[(n - 1) * 2];
		top = 0;
		Arrays.fill(head, -1);
	}

	private static void addEdge(int a, int b, int c) {
		edge[top] = new Edge();
		edge[top].to = b;
		edge[top].next = head[a];
		edge[top].distance = c;
		head[a] = top++;

	}
}
