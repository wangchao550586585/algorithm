import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		int flag = 1;
		int i;
		while (((i = br.read()) & 48) != 48 || i > 57) {
			if (i == 45)
				flag = -1;
		}
		for (; (i & 56) == 48 || (i & 62) == 56; i = br.read()) {
			num = num * 10 + (i & 15);
		}
		num *= flag;
		System.out.println(num);

	}
}
