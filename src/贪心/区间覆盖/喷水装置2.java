package 贪心.区间覆盖;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *区间覆盖
 *贪心策略：所有装置的左覆盖点，从小到大排序，从0开始，在既能保证2点有公共区域的情况下，每次选取覆盖右边最大的喷射装置，不过要注意，中间不能有隔阂，
 *这里使用优先级队列,每次删除无效数据。
 */
public class 喷水装置2 {
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
			Queue<Node> arr = new PriorityQueue<Node>(m, comparator);
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				double xi = Double.parseDouble(st.nextToken());
				double ri = Double.parseDouble(st.nextToken());
				if (ri > height) {// 小于高的一半，不添加，剪枝
					double f = Math.sqrt(ri * ri - height * height);
					arr.add(new Node(xi - f, xi + f));
				}
			}
			double start = 0;// 记录左边值
			double right = 0;
			Node node = null;
			int count = 0;
			while (!arr.isEmpty()) {
				// right =
				// Double.MIN_VALUE;可以省略，因为只会在大于start时，赋值给start，说明跟start相等，小于或者等于结束
				node = null;
				// 在公共区域，同时右边覆盖范围最大
				while (!arr.isEmpty() && arr.peek().left <= start) {
					if (arr.peek().right > right) {// 如果right之前更新了一个值，那么就要删除之前更新的那个Node
						right = arr.peek().right;
						if (node != null)
							arr.remove(node);
						node = arr.poll();
					} else {
						arr.poll();// 剪枝
					}
				}
				/*
				 * 1:没更新right，说明不能湿润草坪
				 * 2:更新了，判断是否大于start，是的话，更新start值,同时也remove(Node)，count记录个数，不是的，数据不合法，返回0
				 * 3：判断start是否大于width，是的话，返回count+1
				 */
				if (right == start) {// right没更新或者没有找到大于start范围的装置，结束
					count = 0;
					break;
				} else {
					start = right;
					count++;
					arr.remove(node);
				}
				if (start > width) {
					break;
				}

			}
			System.out.println(count);

		}
	}
}
