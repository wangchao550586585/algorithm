package ̰��;
import java.util.Scanner;

/*
 * ����20����ɾ��9������֮��11�����������˳��ֵ���
 * ������ǣ���20�����ҵ�11������
 * ��һ���϶���1~1+9֮�䣬
 * �ڶ����϶���2~2+9֮�䣬
 * ...
 * ��ʮһ���϶���11~11+9֮�䣬
 * ����ת��������Ѱ�����ֵ
 */
public class Ѱ������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			char[] m = sc.next().toCharArray();
			int s = sc.nextInt();
			String str = "";
			int index = -1;// ���ﱣ�������ұߵ�ֵ
			for (int i = 0; i < m.length - s; i++) {
				char temp = Character.MIN_VALUE;//֮���в��ܸ�ֵΪm[i]����Ϊ���ܱ�str���á�����Ҳ�ܱ�֤indexÿ��+1
				for (int j = index + 1; j <= i + s; j++) {
					if (temp < m[j]) {
						temp = m[j];
						index = j;
					}
				}
				str += temp;
			}
			System.out.println(str);

		}

	}
}
