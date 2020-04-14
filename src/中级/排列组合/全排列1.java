package 中级.排列组合;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 全排列1 {
	static int size;
	static int count;
	static char[] arrChar = new char[100];

	public static void main(String[] args) throws IOException {
		System.out.print("Enter a word:");
		String input = getString();
		size = input.length();
		count = 0;
		for (int j = 0; j < size; j++) {
			arrChar[j] = input.charAt(j);
		}
		doAnagrams(size);
	}

	private static void doAnagrams(int newSize) {
		if (newSize == 1)
			return;
		for (int j = 0; j < newSize; j++) {
			doAnagrams(newSize - 1);
			if (newSize == 2)
				displayWord();
			rotate(newSize);
		}
	}

	private static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position];
		for (j = position + 1; j < size; j++) {
			arrChar[j - 1] = arrChar[j];
		}
		arrChar[j - 1] = temp;
	}

	private static void displayWord() {
		System.out.print(++count + " ");
		for (int j = 0; j < size; j++) {
			System.out.print(arrChar[j]);
		}
		System.out.print(" ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println(" ");
	}

	private static String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

}
