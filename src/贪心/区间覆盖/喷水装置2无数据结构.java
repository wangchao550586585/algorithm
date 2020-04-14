package 贪心.区间覆盖;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 喷水装置2无数据结构 {
	static class Node {
		double left;
		double right;

		public Node(double d, double e) {
			this.left = d;
			this.right = e;
		}

	}

	static Comparator<Node> comparator = new Comparator<Node>() {
		public int compare(Node o1, Node o2) {
			return Double.compare(o1.left, o2.left);
		}
	};

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			double width = Double.parseDouble(st.nextToken());
			double height = Double.parseDouble(st.nextToken()) / 2;
			Node[] node = new Node[m];
			int sum_Count = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				double xi = Double.parseDouble(st.nextToken());
				double ri = Double.parseDouble(st.nextToken());
				if (ri > height) {
					double f = Math.sqrt(ri * ri - height * height);
					node[sum_Count++] = new Node(xi - f, xi + f);
				}
			}
			Arrays.sort(node, 0, sum_Count, comparator);// 长度
			double start = 0;
			double right = 0;
			int result = 0;
			int currentIndex = 0;
			while (start < width) {
				for (int i = currentIndex; i < sum_Count; i++) {
					if (node[i].left <= start && node[i].right > right) {
						right = node[i].right;
						currentIndex = i;// 优化。
					}
				}
				if (right == start) {
					result = 0;
					break;
				} else {
					start = right;
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
