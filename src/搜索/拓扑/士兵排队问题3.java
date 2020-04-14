package 搜索.拓扑;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*
 * dfs完成拓扑,针对没有2者之间没有相互联系的会出现问题
 */
public class 士兵排队问题3 {
	static Queue<Integer> que = new LinkedList<Integer>();
	static Map<Integer, LinkedList<Integer>> map = new HashMap<>();
	static Stack<Character> rer = new Stack<>();
	static char result[];
	static int count = 0;
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		result = new char[100];
		visited = new boolean[26];
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

			visited[a] = true;
			visited[b] = true;
		}
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			LinkedList<Integer> linkedList = map.get(i);
			Collections.sort(linkedList);
			map.put(i, linkedList);
		}
		for (int i = 0; i < 26; i++) {
			if (visited[i]) {
				dfs(i);
			}
		}
		int count = rer.size();
		for (int i = 0; i < count; i++) {
			System.out.print(rer.pop());
		}
	}

	private static void dfs(int re) {
		visited[re] = false;
		LinkedList<Integer> linkedlist = map.get(re);
		if (linkedlist != null) {
			for (int i : linkedlist) {
				if (visited[i])
					dfs(i);
			}
		}
		rer.add((char) ('A' + re));
	}
}
