package 贪心;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class 线段和点_优化版 {
	private static InputStream is = System.in;

	public static int nextInt() {
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

	static class Node {
		public int start;
		public int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) {
		int n = nextInt();
		int m = nextInt();
		int point[] = new int[n];
		for (int i = 0; i < n; i++)
			point[i] = nextInt();
		Node node[] = new Node[m];
		for (int i = 0; i < m; i++)
			node[i] = new Node(nextInt(), nextInt());
		Arrays.sort(point);
		Arrays.sort(node, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.end - o2.end;
			}
		});
		int currentPoint = 0;
		int count = 0;
		int j = 1;
		for (int i = 0; i < m; i++) {
			int x = node[i].start;
			int y = node[i].end;
			if (x <= currentPoint)
				continue;
			int temp = -1;
			for (j -= 1; j < n; j++) {
				if (point[j] <= y) {
					temp = point[j];
				} else {
					break;
				}
			}
			if (temp == -1) {
				count = 0;
				break;
			} else {
				currentPoint = temp;
				count++;
			}

		}
		System.out.println(count);
	}
}
