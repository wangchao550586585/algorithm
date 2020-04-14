package 动态规划;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 4点构成一个矩形， 坐标的取值范围是：1~1000
 * 
 * @author Administrator
 * 
 */
 class Rectangle {
	public double x;
	public double x1;
	public double y;
	public double y1;

	public Rectangle() {
	}

	public Rectangle(double x, double x1, double y, double y1) {
		this.x = x;
		this.x1 = x1;
		this.y = y;
		this.y1 = y1;
	}

	/**
	 * 判读是否在矩形中
	 */
	public boolean inRectangle(Point p) {
		return p.x > x && p.x < x1 && p.y > y && p.y < y1;

	}
} 
class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
public class 最小距离 {

	public static void main(String[] args) {
		// 测试时间
		long time = System.currentTimeMillis();

		// 1：读取文件
		ArrayList<Point> coordinateList = ReadFile("src/p4.txt");
		// 2:获取最小距离平均值
		double result = getResult(coordinateList,
				new Rectangle(0, 100, 0, 1000));

		// 3：格式转换并输出
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.print(df.format(result) + " ");

		long time1 = System.currentTimeMillis();
		System.out.print("用时:" + (time1 - time));

		// p5.tx：0.50 用时6944
		// p4.tx：8.09 用时70

		// p5.tx：0.50 用时：4110
		// p4.tx：1.67用时：510
	}

	/**
	 * 获取最小距离平均值
	 * 
	 * @param coordinateList
	 * @param rectangle
	 * @return
	 */
	private static double getResult(ArrayList<Point> pList, Rectangle rectangle) {
		int size = pList.size();
		double minDistance = 10000;
		if (size < 4)// 没4点无法进行判断
			return minDistance;
		if (size < 13) {// 13个点，下面在4分，则无一区域有4点。
			double re;
			for (int i = 0; i < size; i++)
				for (int k = i + 1; k < size; k++)
					for (int j = k + 1; j < size; j++)
						for (int p = j + 1; p < size; p++) {
							// 获取4点平均值
							re = distance(pList.get(i), pList.get(k),
									pList.get(j), pList.get(p));
							minDistance = minDistance > re ? re : minDistance;
						}
			return minDistance;
		}

		double x = rectangle.x1;
		double x1 = rectangle.x;
		double y = rectangle.y1;
		double y1 = rectangle.y;
		// 缩小边界
		for (int i = 0; i < size; i++) {
			Point point = pList.get(i);
			if (point.x < x)
				x = point.x;
			if (point.x > x1)
				x1 = point.x;
			if (point.y < y)
				y = point.y;
			if (point.y > y1)
				y1 = point.y;
		}

		// 矩形4分(周边范围全部辐射到即可)
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		Rectangle r3 = new Rectangle();
		Rectangle r4 = new Rectangle();

		r1.x = x;
		r1.y = y;
		r1.x1 = x * 0.25 + x1 * 0.75;
		r1.y1 = y * 0.25 + y1 * 0.75;
		// 右上 a
		r2.x = x * 0.75 + x1 * 0.25;
		r2.y = y;
		r2.x1 = x1;
		r2.y1 = y * 0.25 + y1 * 0.75;
		// 左下 a a
		r3.x = x;
		r3.y = y * 0.75 + y1 * 0.25;
		r3.x1 = x * 0.25 + x1 * 0.75;
		r3.y1 = y1;
		// 右下 a a
		r4.x = x * 0.75 + x1 * 0.25;
		r4.y = y * 0.75 + y1 * 0.25;
		r4.x1 = x1;
		r4.y1 = y1;

		// 集合4分
		ArrayList<Point> p1 = new ArrayList<>();
		ArrayList<Point> p2 = new ArrayList<>();
		ArrayList<Point> p3 = new ArrayList<>();
		ArrayList<Point> p4 = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			Point p = pList.get(i);
			// 判断是否在这点中
			if (r1.inRectangle(p))
				p1.add(p);
			if (r2.inRectangle(p))
				p2.add(p);
			if (r3.inRectangle(p))
				p3.add(p);
			if (r4.inRectangle(p))
				p4.add(p);
		}

		// 获取4矩形最小值
		double d1 = getResult(p1, r1);
		double d2 = getResult(p2, r2);
		double d3 = getResult(p3, r3);
		double d4 = getResult(p4, r4);
		minDistance = d1;
		if (d2 < minDistance)
			minDistance = d2;
		if (d3 < minDistance)
			minDistance = d3;
		if (d4 < minDistance)
			minDistance = d4;
		
		return minDistance;
	}

	/**
	 * 获取4点平均值
	 * 
	 * @param point
	 * @param point2
	 * @param point3
	 * @param point4
	 * @return
	 */
	private static double distance(Point p1, Point p2, Point p3, Point p4) {
		return (d(p1, p2) + d(p1, p3) + d(p1, p4) + d(p2, p3) + d(p2, p4) + d(
				p3, p4)) / 6;

	}

	/**
	 * 获取2点值
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static double d(Point p1, Point p2) {
		double x = p1.x - p2.x;
		double y = p1.y - p2.y;
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * 读取文件
	 * 
	 * @param filePath
	 * @return
	 */
	private static ArrayList<Point> ReadFile(String filePath) {
		ArrayList<Point> coordinateList = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filePath));
			coordinateList = new ArrayList<Point>();
			String readLine;
			while ((readLine = br.readLine()) != null) {
				String[] split = readLine.split(",");
				coordinateList.add(new Point(// 建立point点
						Integer.parseInt(split[0]),// x坐标
						Integer.parseInt(split[1]))// y坐标
						);
			}
		} catch (Exception e) {
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}

		return coordinateList;
	}
}
