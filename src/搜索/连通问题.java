package 搜索;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class 连通问题 {
	static class Point {
		public boolean isVisited = false;// 是否被访问，默认没访问
		public boolean value = false;// 是否是黑色,默认白色
	}

	public static Point[][] p;// 像素数组
	public static int width;// 像素宽
	public static int height;// 像素高
	public static int result;// 统计面积
	public static int count;// 统计的总个数

	public static void main(String[] args) throws IOException {
		// 1:获取图片流
		BufferedImage read = ImageIO.read(new File("t1.bmp"));
		width = read.getWidth();
		height = read.getHeight();
		// 2：存储每一个坐标
		p = new Point[width][height];
		// 3:坐标数组填值,
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				p[i][k] = new Point();
				if (read.getRGB(i, k) != -1) {// 非白色，则true
					p[i][k].value = true;
				}
			}
		}
		// 4:输出每个连通群体的面积:就是它含有的像素的个数。
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				result = 0;
				scanImage(x, y);// 扫描图片
				if (result == 0) {// 无结果，且全部扫描过
					if (count == height * width) {
						break;
					}
				} else {
					System.out.println(result);
				}
			}

	}

	/**
	 * 扫描图片
	 * 
	 * @param x
	 * @param y
	 */
	private static void scanImage(int x, int y) {
		/*
		 * 1:防止越界
		 */
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return;
		}
		/*
		 * 2:扫描：两个点距离如果小于2个像素，则认为这两个点连通。
		 */
		if (!p[x][y].isVisited) {
			p[x][y].isVisited = true;
			count++;
			if (p[x][y].value) {
				result++;
				scanImage(x, y - 1);
				scanImage(x, y + 1);
				scanImage(x - 1, y);
				scanImage(x - 1, y + 1);
				scanImage(x - 1, y - 1);
				scanImage(x + 1, y);
				scanImage(x + 1, y + 1);
				scanImage(x + 1, y - 1);
			}

		}

	}
}
