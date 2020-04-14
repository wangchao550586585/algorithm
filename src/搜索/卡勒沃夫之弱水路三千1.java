package ËÑË÷;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ¿¨ÀÕÎÖ·òÖ®ÈõË®Â·ÈıÇ§1 {
	static int N;
	static String[] topo = new String[10000];
	static int t = 0;
	static Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	static Map<String, Integer> c = new HashMap<String, Integer>();

	static boolean dfs(String n) {
		c.put(n, -1);
		List<String> ls = map.get(n);
		if (ls != null)
			for (String key : ls) {
				if (c.get(key) != null && c.get(key) == -1)
					return false;
				else if (c.get(key) == null && !dfs(key))
					return false;
			}
		c.put(n, 1);
		topo[t++] = n;

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		while (N-- != 0) {
			int k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				if (map.get(s1) != null) {
					map.get(s1).add(s2);
				} else {
					ArrayList<String> al = new ArrayList<String>();
					al.add(s2);
					map.put(s1, al);
				}
			}
			Set<String> set = map.keySet();
			for (String key : set) {
				if (c.get(key) == null) {
					if (!dfs(key))
						return;
				}
			}
			for (int i = t - 1; i >= 0; i--)
				System.out.print(topo[i] + " ");
			System.out.println();
			map.clear();
			c.clear();
			t = 0;
		}

	}
}
