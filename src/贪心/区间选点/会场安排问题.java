package 贪心.区间选点;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 结束后才能开始新的会场，所以结束的时间要尽可能快，也就是时间从小到大排列
 */
public class 会场安排问题 {
	static class Node {
		public int start;
		public int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			Node[] node = new Node[m];
			for (int i = 0; i < m; i++) {
				node[i] = new Node(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(node, new Comparator<Node>() {
				public int compare(Node o1, Node o2) {
					return o1.end - o2.end;
				}
			});
			int count = 1;
			int end = node[0].end;
			for (int i = 1; i < m; i++) {
				if (node[i].start > end) {
					end = node[i].end;
					count++;
				}
			}
			System.out.println(count);

		}
	}
}
