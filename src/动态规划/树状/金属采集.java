package 动态规划.树状;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/*
 * 问题描述
人类在火星上发现了一种新的金属！这些金属分布在一些奇怪的地方，不妨叫它节点好了。一些节点之间有道路相连，所有的节点和道路形成了一棵树。
一共有 n 个节点，这些节点被编号为 1~n 。人类将 k 个机器人送上了火星，目的是采集这些金属。这些机器人都被送到了一个指定的着落点，
 S 号节点。每个机器人在着落之后，必须沿着道路行走。当机器人到达一个节点时，它会采集这个节点蕴藏的所有金属矿。
 当机器人完成自己的任务之后，可以从任意一个节点返回地球。当然，回到地球的机器人就无法再到火星去了。
 我们已经提前测量出了每条道路的信息，包括它的两个端点 x 和 y，以及通过这条道路需要花费的能量 w 。我们想花费尽量少的能量采集所有节点的金属，这个任务就交给你了。

输入格式
第一行包含三个整数 n, S 和 k ，分别代表节点个数、着落点编号，和机器人个数。

接下来一共 n-1 行，每行描述一条道路。一行含有三个整数 x, y 和 w ，代表在 x 号节点和 y 号节点之间有一条道路，通过需要花费 w 个单位的能量。所有道路都可以双向通行。

输出格式
输出一个整数，代表采集所有节点的金属所需要的最少能量。
样例输入
6 1 3
1 2 1
2 3 1
2 4 1000
2 5 1000
1 6 1000
样例输出
3004
样例说明
所有机器人在 1 号节点着陆。

第一个机器人的行走路径为 1->6 ，在 6 号节点返回地球，花费能量为1000。

第二个机器人的行走路径为 1->2->3->2->4 ，在 4 号节点返回地球，花费能量为1003。

第一个机器人的行走路径为 1->2->5 ，在 5 号节点返回地球，花费能量为1001。

数据规模与约定
本题有10个测试点。

对于测试点 1~2 ， n <= 10 ， k <= 5 。

对于测试点 3 ， n <= 100000 ， k = 1 。

对于测试点 4 ， n <= 1000 ， k = 2 。

对于测试点 5~6 ， n <= 1000 ， k <= 10 。

对于测试点 7~10 ， n <= 100000 ， k <= 10 。

道路的能量 w 均为不超过 1000 的正整数。
 */
class MyScanner {

	private InputStream is = System.in;

	public int nextInt() {
		try {
			int i;

			while ((i = is.read()) < 45 || i > 57) {
			}

			int mark = 1, temp = 0;

			if (i == 45) {
				mark = -1;
				i = is.read();
			}

			while (i > 47 && i < 58) {
				temp = temp * 10 + i - 48;
				i = is.read();
			}

			return temp * mark;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return -1;
	}
}

public class 金属采集 {

	static class Edge {
		public int to;
		public int next;
		public int w;
	}

	private static int head[];
	private static Edge[] edge;
	private static int top;
	private static int dp[][];
	static int k;
	static int s;

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int n = sc.nextInt();
		s = sc.nextInt();
		k = sc.nextInt();
		init(n);
		dp = new int[n + 1][k + 1];
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			addEdge(a, b, c);
			addEdge(b, a, c);
		}
		dfs(s, -1);
		System.out.println(dp[s][k]);
	}

	private static void dfs(int root, int upper) {

		for (int i = head[root]; i != -1; i = edge[i].next) {
			int to = edge[i].to;
			if (to == upper)
				continue;
			dfs(to, root);
			for (int j = k; j >= 0; j--) {
				//保证最少下去一个人的花费
				dp[root][j] += dp[to][0] + 2 * edge[i].w;
				for (int l = 1; l <= j; l++) {
					dp[root][l] = Math.min(dp[root][j], dp[root][j - l]
							+ dp[to][l] + l * edge[i].w);
				}
			}
			
		}

	}

	private static void addEdge(int to, int next, int w) {
		edge[top] = new Edge();
		edge[top].to = next;
		edge[top].w = w;
		edge[top].next = head[to];
		head[to] = top++;
	}

	private static void init(int n) {
		int size = (n - 1) * 2;
		edge = new Edge[size];
		head = new int[size];
		top = 0;
		Arrays.fill(head, -1);
	}
}
