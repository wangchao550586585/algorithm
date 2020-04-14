package ����.����;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ��������Kahn�㷨
 * һ��Ҫȥ�أ�
 * 2���⣺�ظ����⣬�������⡣
 * ������Ϊ�Ǵ�0��ʼ������26�����������򡣵�������ظ����⣬ȴ��Ҫ��ǰ�������ȥ�صĻ������ٵ�һ��n��0��=1
 * 
 * ����
�����Уθ�ʿ��(1�ܣΡ�26)���������Ϊ��,��,��,��������ѵ��ʱ��ָ�ӹ�Ҫ��һЩʿ���Ӹߵ���һ���ų�һ�У�
������ָ�ӹٲ���ֱ�ӻ��ÿ���˵������Ϣ��ֻ�ܻ�á�P1��P2�ߡ������ıȽϽ��(P1��P2�ʣ�,��,��,��,��,��Ϊ P1>P2)���硱��>�¡���ʾ���ȣ¸ߡ�
�������һ���򣬸������õ��ıȽϽ�����һ�ַ����������Ŷӷ�����
������ע���ȽϽ����û���漰��ʿ�����μ��Ŷӣ�
����Ҫ��
�����ȽϽ�����ı��ļ��ж��루�ļ��ɼ������룩��ÿ���ȽϽ�����ı��ļ���ռһ�С�
���Ҫ��
���������������޽⣬��ӡ��No Answer!����Ϣ������Ӹߵ���һ�����ÿһ��ʿ���ı�ţ��м��޷ָ�������ѽ��д���ı��ļ��У��ļ��ɼ������룺
��������
A>B
B>D
F>D
�������
AFBD
 */
public class ʿ���Ŷ����� {
	static Queue<Integer> que = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int arr[][] = new int[26][26];
		char result[] = new char[26];
		int count = 0;
		int[] in = new int[26];
		boolean visited[] = new boolean[26];
		for (int i = 0; i < n; i++) {
			char[] charArray = sc.nextLine().toCharArray();
			int a = charArray[0] - 'A';
			int b = charArray[2] - 'A';
			if (arr[b][a] == 1)// ȥ��
				continue;
			arr[b][a] = 1;
			in[b]++;
			visited[a] = true;
			visited[b] = true;
		}
		int size = 0;
		for (int i = 0; i < 26; i++) {
			if (visited[i]) {
				size++;
				if (in[i] == 0)
					que.add(i);
			}
		}
		while (!que.isEmpty()) {
			Integer remove = que.remove();
			result[count++] = (char) ('A' + remove);
			visited[remove] = false;
			System.out.println(que);
			for (int i = 0; i < 26; i++) {
				if (!visited[i] || arr[i][remove] != 1)
					continue;
				in[i]--;
				if (in[i] == 0)
					que.add(i);
			}

		}
		if (count != size)
			System.out.println("No Answer!");
		else
			for (int i = 0; i < size; i++) {
				System.out.print(result[i]);
			}
	}
}
