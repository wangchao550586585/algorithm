package ̰��;
import java.util.Scanner;

/*
 * �Ӽ��ַ�������֤+�ڶ�Ӧ�ĵط���-��ȻҲ�ڶ�Ӧ�ĵط�
 * 1������ÿ��+�ŵ�λ��
 * 2����ȥ2��֮����ǽ���λ�õ�ֵ
 */
public class �Ӽ��ַ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			char[] src = sc.next().toCharArray();
			char[] dest = sc.next().toCharArray();
			int src1[] = new int[src.length];
			int dest1[] = new int[dest.length];
			int j = 0;
			int k = 0;
			for (int i = 0; i < src.length; i++) {
				if (src[i] == '+') {
					src1[j++] = i;
				}
				if (dest[i] == '+') {
					dest1[k++] = i;
				}
			}
			int result = 0;
			for (int i = 0; i < src.length; i++) {
				result += Math.abs(dest1[i] - src1[i]);
			}
			System.out.println(result);

		}
	}
}
