package 搜索.拓扑;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 拓扑排序：Kahn算法
 * 一定要去重，
 * 2问题：重复问题，排序问题。
 * 本类因为是从0开始遍历到26所以无需排序。但是针对重复问题，却需要提前解决，不去重的话，会少掉一个n【0】=1
 * 
 * 试题
　　有Ｎ个士兵(1≤Ｎ≤26)，编号依次为Ａ,Ｂ,Ｃ,…，队列训练时，指挥官要把一些士兵从高到矮一次排成一行，
但现在指挥官不能直接获得每个人的身高信息，只能获得“P1比P2高”这样的比较结果(P1、P2∈Ａ,Ｂ,Ｃ,…,Ｚ,记为 P1>P2)，如”Ａ>Ｂ”表示Ａ比Ｂ高。
　　请编一程序，根据所得到的比较结果求出一种符合条件的排队方案。
　　（注：比较结果中没有涉及的士兵不参加排队）
输入要求
　　比较结果从文本文件中读入（文件由键盘输入），每个比较结果在文本文件中占一行。
输出要求
　　若输入数据无解，打印“No Answer!”信息，否则从高到矮一次输出每一个士兵的编号，中间无分割符，并把结果写入文本文件中，文件由键盘输入：
样例输入
A>B
B>D
F>D
样例输出
AFBD
 */
public class 士兵排队问题 {
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
			if (arr[b][a] == 1)// 去重
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
