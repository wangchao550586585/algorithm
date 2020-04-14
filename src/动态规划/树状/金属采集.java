package ��̬�滮.��״;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/*
 * ��������
�����ڻ����Ϸ�����һ���µĽ�������Щ�����ֲ���һЩ��ֵĵط������������ڵ���ˡ�һЩ�ڵ�֮���е�·���������еĽڵ�͵�·�γ���һ������
һ���� n ���ڵ㣬��Щ�ڵ㱻���Ϊ 1~n �����ཫ k �������������˻��ǣ�Ŀ���ǲɼ���Щ��������Щ�����˶����͵���һ��ָ��������㣬
 S �Žڵ㡣ÿ��������������֮�󣬱������ŵ�·���ߡ��������˵���һ���ڵ�ʱ������ɼ�����ڵ��̲ص����н�����
 ������������Լ�������֮�󣬿��Դ�����һ���ڵ㷵�ص��򡣵�Ȼ���ص�����Ļ����˾��޷��ٵ�����ȥ�ˡ�
 �����Ѿ���ǰ��������ÿ����·����Ϣ���������������˵� x �� y���Լ�ͨ��������·��Ҫ���ѵ����� w �������뻨�Ѿ����ٵ������ɼ����нڵ�Ľ������������ͽ������ˡ�

�����ʽ
��һ�а����������� n, S �� k ���ֱ����ڵ������������ţ��ͻ����˸�����

������һ�� n-1 �У�ÿ������һ����·��һ�к����������� x, y �� w �������� x �Žڵ�� y �Žڵ�֮����һ����·��ͨ����Ҫ���� w ����λ�����������е�·������˫��ͨ�С�

�����ʽ
���һ������������ɼ����нڵ�Ľ�������Ҫ������������
��������
6 1 3
1 2 1
2 3 1
2 4 1000
2 5 1000
1 6 1000
�������
3004
����˵��
���л������� 1 �Žڵ���½��

��һ�������˵�����·��Ϊ 1->6 ���� 6 �Žڵ㷵�ص��򣬻�������Ϊ1000��

�ڶ��������˵�����·��Ϊ 1->2->3->2->4 ���� 4 �Žڵ㷵�ص��򣬻�������Ϊ1003��

��һ�������˵�����·��Ϊ 1->2->5 ���� 5 �Žڵ㷵�ص��򣬻�������Ϊ1001��

���ݹ�ģ��Լ��
������10�����Ե㡣

���ڲ��Ե� 1~2 �� n <= 10 �� k <= 5 ��

���ڲ��Ե� 3 �� n <= 100000 �� k = 1 ��

���ڲ��Ե� 4 �� n <= 1000 �� k = 2 ��

���ڲ��Ե� 5~6 �� n <= 1000 �� k <= 10 ��

���ڲ��Ե� 7~10 �� n <= 100000 �� k <= 10 ��

��·������ w ��Ϊ������ 1000 ����������
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

public class �����ɼ� {

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
				//��֤������ȥһ���˵Ļ���
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
