package ËÑË÷;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ¿¨ÀÕÎÖ·òÖ®ÈõË®Â·ÈıÇ§ {
	static Map<String, ArrayList<String>> map = new HashMap<>();
	static String[] result = new String[1000];
	static int top = 0;
	static HashSet<String> visited = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				ArrayList<String> arrayList = map.get(s1);
				if (arrayList == null) {
					arrayList = new ArrayList<>();
				}
				arrayList.add(s2);
				map.put(s1, arrayList);
			}
			Set<String> set = map.keySet();
			for (String str : set) {
				if (!visited.contains(str)) {
					dfs(str);
				}
			}
			for (int i = top - 1; i >= 0; i--) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			result = new String[1000];
			top = 0;
			map.clear();
			visited.clear();
		}

	}

	private static void dfs(String str) {
		visited.add(str);
		ArrayList<String> arrayList = map.get(str);
		if (arrayList != null) {
			for (String s : arrayList) {
				if (!visited.contains(s)) {
					dfs(s);
				}
			}
		}
		result[top++] = str;
	}
}
