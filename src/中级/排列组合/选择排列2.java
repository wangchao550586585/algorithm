package 中级.排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 选择排列2 {
	static int k = 3;
	static int m = 5;
	static ArrayList<int[]> arr = new ArrayList<int[]>();

	public static void main(String[] args) {
		arrange(0, new int[k], 0);
		display();
	}

	private static void display() {
		for (int[] a : arr) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + 1 + " ");
			}
			System.out.println();
		}
	}

	private static void arrange(int count, int[] isVisit, int index) {
		if (count == k) {
			arr.add(Arrays.copyOf(isVisit, isVisit.length));
			return;
		}
		if (index == m) {
			return;
		}
		isVisit[count] = index;
		arrange(count + 1, isVisit, index + 1);
		arrange(count, isVisit, index + 1);

	}

}
