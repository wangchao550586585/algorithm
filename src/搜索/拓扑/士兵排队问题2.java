package 搜索.拓扑;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/*
 * 使用一键多值，不需要去重，因为，集合里面保存了重复信息
 * 要解决排序问题。因为是从前往后排序的
 *	排序问题
 *		map#LinkedList进行排序
 *	去重问题
 *		不去重，不过要排序
 *	去重(前提，判断是否有，有n【i】则不加1)：
 *		hash结构|数组
 *		
 */
public class 士兵排队问题2 {
	static Queue<Integer> que = new LinkedList<Integer>();
	static Map<Integer, LinkedList<Integer>> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		char result[] = new char[26];
		int count = 0;
		int[] in = new int[26];
		boolean visited[] = new boolean[26];
		for (int i = 0; i < n; i++) {
			char[] charArray = sc.nextLine().toCharArray();
			int a = charArray[0] - 'A';
			int b = charArray[2] - 'A';
			LinkedList<Integer> linkedlist = map.get(a);
			if (linkedlist == null) {
				linkedlist = new LinkedList<>();
			}
			linkedlist.add(b);
			map.put(a, linkedlist);
			in[b]++;
			visited[a] = true;
			visited[b] = true;
		}
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			LinkedList<Integer> linkedList = map.get(i);
			Collections.sort(linkedList);
			map.put(i, linkedList);
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
			LinkedList<Integer> linkedlist = map.get(remove);
			if (linkedlist == null)
				continue;
			for (int i : linkedlist) {
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
