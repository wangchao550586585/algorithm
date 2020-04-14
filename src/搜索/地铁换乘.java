package 搜索;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 利用深度查询 A-B 第一条线路有
 * 
 * @author Administrator
 * 
 */

public class 地铁换乘 {
	static class Line {
		// 线路名
		public String lineName;
		// 站点集合
		public ArrayList<String> site = new ArrayList<String>();
		// 相交的节点
		public HashSet<Line> acrossLine = new HashSet<Line>();

		@Override
		public String toString() {
			return "Line [lineName=" + lineName + ", site=" + site.toString()
					+ ", acrossLine=" + acrossLine.toString() + "]";
		}
	}

	static ArrayList<Line> liArr = new ArrayList<Line>();// 所有线路
	static Map<String, Integer> priceArr = new HashMap<String, Integer>();// 所有路线价格
	static ArrayList<String> resultSet = new ArrayList<String>();// 结果集
	static ArrayList<String> a = new ArrayList<String>();// 用来过滤重复结果
	// 1:读取线路
	static {
		try {
			// 读取线路
			readLine();
			// 读取价格
			readPrice();
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入起始站和终点:");
		String str = sc.nextLine();
		// 2：查询起点到终点所有线路
		findLine(str);
		// 3:最优价格以及路线
		String result = getLinePrice();
		// 4:输出
		System.out.println(result);
	}

	/**
	 * 3:最优价格
	 * 
	 * @return
	 */
	private static String getLinePrice() {
		int[] priceAr = new int[resultSet.size()];
		for (int i = 0; i < resultSet.size(); i++) {
			String[] st = resultSet.get(i).split("-");// 路线数组
			int price = 0;// 花费
			String str = "";// 路线
			boolean flag = false;// 上一条线路是否是联合票
			for (int k = 1; k < st.length; k++) {
				// 不包含联合票,解决了单程问题,巧妙利用之前添加的"-"
				if (!priceArr.containsKey(st[k - 1] + st[k])) {
					price += priceArr.get(st[k]);
					str = str + "-" + st[k];
					flag = false;
					continue;
				}
				/*
				 * 包含联合票价 1：前一个线路包含联合票价 2：前一个线路不包含联合票价
				 */
				if (flag) {
					int p1 = priceArr.get(st[k - 2] + st[k - 1])
							+ priceArr.get(st[k]);
					int p2 = priceArr.get(st[k - 1] + st[k])
							+ priceArr.get(st[k - 2]);
					if (p1 <= p2) {
						price += priceArr.get(st[k]);
						str = str + "-" + st[k];
					} else {
						price = price - priceArr.get(st[k - 2] + st[k - 1])
								+ p2;
						str = str.replace("(" + st[k - 2] + "," + st[k - 1]
								+ ")", st[k - 2] + "-(" + st[k - 1] + ","
								+ st[k] + ")");
					}
				} else {
					price -= priceArr.get(st[k - 1]);
					price += priceArr.get(st[k - 1] + st[k]);
					str = str.replace(st[k - 1], "(" + st[k - 1] + "," + st[k]
							+ ")");
				}

				flag = true;

			}
			// 更新票价以及路线结果集
			resultSet.set(i, str);
			priceAr[i] = price;
		}

		int minIndex = 0;
		for (int i = 1; i < priceAr.length; i++) {
			if (priceAr[i] < priceAr[minIndex]) {
				minIndex = i;
			}
		}
		return resultSet.get(minIndex) + " " + priceAr[minIndex] + "";

	}

	/**
	 * 查询起点到终点所有线路
	 * 
	 * @param str
	 */
	private static void findLine(String str) {
		String[] split = str.split(",");
		String start = split[0];// 起点
		String end = split[1];// 终点
		ArrayList<Line> startLine = new ArrayList<>();
		ArrayList<Line> endLine = new ArrayList<>();
		/*
		 * 1:包含起点和终点分别添加入对应的集合中
		 */
		for (Line l : liArr) {
			if (l.site.contains(start))
				startLine.add(l);
			if (l.site.contains(end))
				endLine.add(l);
		}
		/*
		 * 2:判断，<0：说明无线路。异常
		 */
		if (startLine.size() == 0 || endLine.size() == 0) {
			new Exception("无效输入");
		}

		/*
		 * 3:获取起点到终点的所有方案
		 */
		for (Line l1 : startLine)
			for (Line l2 : endLine) {
				a.add(l1.lineName);
				// 迭代l1-l2所有结果
				findResult(resultSet.size(), l1, l2, " -" + l1.lineName);
			}

	}

	/**
	 * 查找乘车线路
	 * 
	 * @param rn
	 *            :乘车方案个数，作用，用来判断是否到了终点
	 * @param l1
	 *            ：起点
	 * @param l2
	 *            :终点
	 * @param result
	 *            :方案
	 */
	private static void findResult(int rn, Line l1, Line l2, String result) {
		/*
		 * 情况1：单程线路 
		 * 情况2:2-多程线路
		 */
		if (l1 == l2) {
			resultSet.add(result);
			return;
		}
		/*
		 * 情况2：交叉线路
		 */
		for (Line acrossLine : l1.acrossLine) {
			// 线路已经被找过
			if (a.contains(acrossLine.lineName)) {
				continue;
			}
			// 找到终点时
			if (acrossLine == l2) {
				a.add(acrossLine.lineName);
				resultSet.add(result + "-" + acrossLine.lineName);
			}
		}
		/*
		 * 情况3：多×线路
		 */
		if (resultSet.size() > rn)// 说明rn在前面改变过，间接说明已经找到了终点
			return;
		for (Line acrossLine : l1.acrossLine) {
			// 线路已经被找过
			if (a.contains(acrossLine.lineName)) {
				continue;
			}
			a.add(acrossLine.lineName);
			findResult(resultSet.size(), acrossLine, l2, result + "-"
					+ acrossLine.lineName);
		}

	}

	/**
	 * 读取价格
	 * 
	 * @throws Exception
	 */
	private static void readPrice() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("src/price.txt"));
		String p;
		while ((p = br.readLine()) != null) {
			String[] split = p.split(" ");
			if (split[0].contains(",")) {// 说明是交叉线路
				String[] split2 = split[0].split(",");
				priceArr.put(split2[0] + split2[1], Integer.parseInt(split[1]));
				priceArr.put(split2[1] + split2[0], Integer.parseInt(split[1]));
			} else {// 单程车票
				priceArr.put(split[0], Integer.parseInt(split[1]));
			}
		}
		br.close();
	}

	/**
	 * 读取线路
	 * 
	 * @throws Exception
	 */
	private static void readLine() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"src/stations.txt"));
		ArrayList<String> temp = new ArrayList<String>();
		String p;
		Line l = null;
		while ((p = br.readLine()) != null) {
			if (p.contains("线")) {// 说明开始
				l = new Line();
				l.lineName = p;
				liArr.add(l);
			} else if (p.equals(""))
				continue;
			else {
				l.site.add(p);
			}
			// 说明有交叉路线
			if (temp.contains(p)) {
				findCrossL(p, l);
			} else {
				temp.add(p);
			}

		}
		br.close();

	}

	/**
	 * 添加交叉路线
	 * 
	 * @param p
	 * @param l
	 */
	private static void findCrossL(String p, Line l) {
		for (int i = 0; i < liArr.size() - 1; i++) {// 减1，是因为不包含当前线路
			Line line = liArr.get(i);
			// 包含当前站点，说明互为交叉
			if (line.site.contains(p)) {
				line.acrossLine.add(l);
				l.acrossLine.add(line);
			}
		}

	}
}
