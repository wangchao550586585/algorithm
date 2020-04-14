package ̰��.���串��;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *���串��
 *̰�Ĳ��ԣ�����װ�õ��󸲸ǵ㣬��С�������򣬴�0��ʼ���ڼ��ܱ�֤2���й������������£�ÿ��ѡȡ�����ұ���������װ�ã�����Ҫע�⣬�м䲻���и��ң�
 *����ʹ�����ȼ�����,ÿ��ɾ����Ч���ݡ�
 */
public class ��ˮװ��2 {
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
				if (ri > height) {// С�ڸߵ�һ�룬����ӣ���֦
					double f = Math.sqrt(ri * ri - height * height);
					arr.add(new Node(xi - f, xi + f));
				}
			}
			double start = 0;// ��¼���ֵ
			double right = 0;
			Node node = null;
			int count = 0;
			while (!arr.isEmpty()) {
				// right =
				// Double.MIN_VALUE;����ʡ�ԣ���Ϊֻ���ڴ���startʱ����ֵ��start��˵����start��ȣ�С�ڻ��ߵ��ڽ���
				node = null;
				// �ڹ�������ͬʱ�ұ߸��Ƿ�Χ���
				while (!arr.isEmpty() && arr.peek().left <= start) {
					if (arr.peek().right > right) {// ���right֮ǰ������һ��ֵ����ô��Ҫɾ��֮ǰ���µ��Ǹ�Node
						right = arr.peek().right;
						if (node != null)
							arr.remove(node);
						node = arr.poll();
					} else {
						arr.poll();// ��֦
					}
				}
				/*
				 * 1:û����right��˵������ʪ���ƺ
				 * 2:�����ˣ��ж��Ƿ����start���ǵĻ�������startֵ,ͬʱҲremove(Node)��count��¼���������ǵģ����ݲ��Ϸ�������0
				 * 3���ж�start�Ƿ����width���ǵĻ�������count+1
				 */
				if (right == start) {// rightû���»���û���ҵ�����start��Χ��װ�ã�����
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
