import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.StreamTokenizer;

class Scann {
	public static BufferedInputStream bis = new BufferedInputStream(System.in);

	public static int nextIn() throws IOException {
		int i = bis.read(), sum = 0;
		while (i < 48 || i > 57)
			i = bis.read();
		while (i > 47 && i < 58) {
			sum = sum * 10 + i - 48;
			i = bis.read();
		}
		return sum;
	}

	////////////////
	
	BufferedReader br;
	StringTokenizer st;

	Scann(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
		eat("");
	}

	private void eat(String string) {
		st = new StringTokenizer(string);
	}

	String nextLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	boolean hasNext() {
		while (!st.hasMoreTokens()) {
			String s = nextLine();
			if (s == null)
				return false;
			eat(s);
		}
		return true;
	}

	String next() {
		hasNext();
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}
}

class d {
	static StreamTokenizer st = new StreamTokenizer(new BufferedReader(
			new InputStreamReader(System.in)));

	public static void main(String[] args) throws IOException {
		while (st.nextToken() != st.TT_EOF) {
			// double nval 如果当前标记是一个数字，则此字段将包含该数字的值。
			// String sval : 如果当前标记是一个文字标记，则此字段包含一个给出该文字标记的字符的字符串。
			st.nextToken();// 获取标记
			int j = (int) st.nval;// 获取值
		}
	}
}

class s {
	private static BufferedInputStream in = new BufferedInputStream(System.in);

	private static int readInt() throws IOException {
		int i, sum = 0, flag = 1;

		while (((i = in.read()) & 48) != 48 || i > 57) {
			if (i == 45)
				flag = -1;
		}
		for (; (i & 56) == 48 || (i & 62) == 56; i = in.read())
			sum = sum * 10 + (i & 15);
		return sum * flag;
	}

}

class MyInputStream {
	private BufferedInputStream bis = new BufferedInputStream(System.in);

	public int getInt() throws IOException {
		int i = 0;
		while ((i = bis.read()) < 48)
			if (i == -1)
				return -1;
		int temp = 0;
		while (i > 47) {
			temp = temp * 10 + i - 48;
			i = bis.read();
		}
		return temp;
	}

}

class Sc {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void init() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreElements()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
