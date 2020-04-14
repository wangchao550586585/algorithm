

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class º∆À„»’∆⁄ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			String[] split = str.split(" ");
			int year = Integer.parseInt(split[0]);
			int month = Integer.parseInt(split[1]);
			if (month < 3) {
				month += 12;
				year--;
			}
			int day = Integer.parseInt(split[2]);
			int result = (day + 2 * month + 3 * (month + 1) / 5 + year + year
					/ 4 - year / 100 + year / 400 + 1) % 7;
			System.out.println(result);
		}

	}
}
