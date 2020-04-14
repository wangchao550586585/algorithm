package ����;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * ������Ȳ�ѯ A-B ��һ����·��
 * 
 * @author Administrator
 * 
 */

public class �������� {
	static class Line {
		// ��·��
		public String lineName;
		// վ�㼯��
		public ArrayList<String> site = new ArrayList<String>();
		// �ཻ�Ľڵ�
		public HashSet<Line> acrossLine = new HashSet<Line>();

		@Override
		public String toString() {
			return "Line [lineName=" + lineName + ", site=" + site.toString()
					+ ", acrossLine=" + acrossLine.toString() + "]";
		}
	}

	static ArrayList<Line> liArr = new ArrayList<Line>();// ������·
	static Map<String, Integer> priceArr = new HashMap<String, Integer>();// ����·�߼۸�
	static ArrayList<String> resultSet = new ArrayList<String>();// �����
	static ArrayList<String> a = new ArrayList<String>();// ���������ظ����
	// 1:��ȡ��·
	static {
		try {
			// ��ȡ��·
			readLine();
			// ��ȡ�۸�
			readPrice();
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ʼվ���յ�:");
		String str = sc.nextLine();
		// 2����ѯ��㵽�յ�������·
		findLine(str);
		// 3:���ż۸��Լ�·��
		String result = getLinePrice();
		// 4:���
		System.out.println(result);
	}

	/**
	 * 3:���ż۸�
	 * 
	 * @return
	 */
	private static String getLinePrice() {
		int[] priceAr = new int[resultSet.size()];
		for (int i = 0; i < resultSet.size(); i++) {
			String[] st = resultSet.get(i).split("-");// ·������
			int price = 0;// ����
			String str = "";// ·��
			boolean flag = false;// ��һ����·�Ƿ�������Ʊ
			for (int k = 1; k < st.length; k++) {
				// ����������Ʊ,����˵�������,��������֮ǰ��ӵ�"-"
				if (!priceArr.containsKey(st[k - 1] + st[k])) {
					price += priceArr.get(st[k]);
					str = str + "-" + st[k];
					flag = false;
					continue;
				}
				/*
				 * ��������Ʊ�� 1��ǰһ����·��������Ʊ�� 2��ǰһ����·����������Ʊ��
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
			// ����Ʊ���Լ�·�߽����
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
	 * ��ѯ��㵽�յ�������·
	 * 
	 * @param str
	 */
	private static void findLine(String str) {
		String[] split = str.split(",");
		String start = split[0];// ���
		String end = split[1];// �յ�
		ArrayList<Line> startLine = new ArrayList<>();
		ArrayList<Line> endLine = new ArrayList<>();
		/*
		 * 1:���������յ�ֱ�������Ӧ�ļ�����
		 */
		for (Line l : liArr) {
			if (l.site.contains(start))
				startLine.add(l);
			if (l.site.contains(end))
				endLine.add(l);
		}
		/*
		 * 2:�жϣ�<0��˵������·���쳣
		 */
		if (startLine.size() == 0 || endLine.size() == 0) {
			new Exception("��Ч����");
		}

		/*
		 * 3:��ȡ��㵽�յ�����з���
		 */
		for (Line l1 : startLine)
			for (Line l2 : endLine) {
				a.add(l1.lineName);
				// ����l1-l2���н��
				findResult(resultSet.size(), l1, l2, " -" + l1.lineName);
			}

	}

	/**
	 * ���ҳ˳���·
	 * 
	 * @param rn
	 *            :�˳��������������ã������ж��Ƿ����յ�
	 * @param l1
	 *            �����
	 * @param l2
	 *            :�յ�
	 * @param result
	 *            :����
	 */
	private static void findResult(int rn, Line l1, Line l2, String result) {
		/*
		 * ���1��������· 
		 * ���2:2-�����·
		 */
		if (l1 == l2) {
			resultSet.add(result);
			return;
		}
		/*
		 * ���2��������·
		 */
		for (Line acrossLine : l1.acrossLine) {
			// ��·�Ѿ����ҹ�
			if (a.contains(acrossLine.lineName)) {
				continue;
			}
			// �ҵ��յ�ʱ
			if (acrossLine == l2) {
				a.add(acrossLine.lineName);
				resultSet.add(result + "-" + acrossLine.lineName);
			}
		}
		/*
		 * ���3�������·
		 */
		if (resultSet.size() > rn)// ˵��rn��ǰ��ı�������˵���Ѿ��ҵ����յ�
			return;
		for (Line acrossLine : l1.acrossLine) {
			// ��·�Ѿ����ҹ�
			if (a.contains(acrossLine.lineName)) {
				continue;
			}
			a.add(acrossLine.lineName);
			findResult(resultSet.size(), acrossLine, l2, result + "-"
					+ acrossLine.lineName);
		}

	}

	/**
	 * ��ȡ�۸�
	 * 
	 * @throws Exception
	 */
	private static void readPrice() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("src/price.txt"));
		String p;
		while ((p = br.readLine()) != null) {
			String[] split = p.split(" ");
			if (split[0].contains(",")) {// ˵���ǽ�����·
				String[] split2 = split[0].split(",");
				priceArr.put(split2[0] + split2[1], Integer.parseInt(split[1]));
				priceArr.put(split2[1] + split2[0], Integer.parseInt(split[1]));
			} else {// ���̳�Ʊ
				priceArr.put(split[0], Integer.parseInt(split[1]));
			}
		}
		br.close();
	}

	/**
	 * ��ȡ��·
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
			if (p.contains("��")) {// ˵����ʼ
				l = new Line();
				l.lineName = p;
				liArr.add(l);
			} else if (p.equals(""))
				continue;
			else {
				l.site.add(p);
			}
			// ˵���н���·��
			if (temp.contains(p)) {
				findCrossL(p, l);
			} else {
				temp.add(p);
			}

		}
		br.close();

	}

	/**
	 * ��ӽ���·��
	 * 
	 * @param p
	 * @param l
	 */
	private static void findCrossL(String p, Line l) {
		for (int i = 0; i < liArr.size() - 1; i++) {// ��1������Ϊ��������ǰ��·
			Line line = liArr.get(i);
			// ������ǰվ�㣬˵����Ϊ����
			if (line.site.contains(p)) {
				line.acrossLine.add(l);
				l.acrossLine.add(line);
			}
		}

	}
}
