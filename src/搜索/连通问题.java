package ����;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ��ͨ���� {
	static class Point {
		public boolean isVisited = false;// �Ƿ񱻷��ʣ�Ĭ��û����
		public boolean value = false;// �Ƿ��Ǻ�ɫ,Ĭ�ϰ�ɫ
	}

	public static Point[][] p;// ��������
	public static int width;// ���ؿ�
	public static int height;// ���ظ�
	public static int result;// ͳ�����
	public static int count;// ͳ�Ƶ��ܸ���

	public static void main(String[] args) throws IOException {
		// 1:��ȡͼƬ��
		BufferedImage read = ImageIO.read(new File("t1.bmp"));
		width = read.getWidth();
		height = read.getHeight();
		// 2���洢ÿһ������
		p = new Point[width][height];
		// 3:����������ֵ,
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				p[i][k] = new Point();
				if (read.getRGB(i, k) != -1) {// �ǰ�ɫ����true
					p[i][k].value = true;
				}
			}
		}
		// 4:���ÿ����ͨȺ������:���������е����صĸ�����
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				result = 0;
				scanImage(x, y);// ɨ��ͼƬ
				if (result == 0) {// �޽������ȫ��ɨ���
					if (count == height * width) {
						break;
					}
				} else {
					System.out.println(result);
				}
			}

	}

	/**
	 * ɨ��ͼƬ
	 * 
	 * @param x
	 * @param y
	 */
	private static void scanImage(int x, int y) {
		/*
		 * 1:��ֹԽ��
		 */
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return;
		}
		/*
		 * 2:ɨ�裺������������С��2�����أ�����Ϊ����������ͨ��
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
