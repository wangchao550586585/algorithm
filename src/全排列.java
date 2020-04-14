import java.util.Arrays;

public class х╚ееап {
	public static void main(String[] args) {
		f(new int[] { 1, 2, 3}, 0);
	}

	private static void f(int[] is, int index) {
		if(index==is.length){
			System.out.println(Arrays.toString(is));
		}
		for (int i = index; i < is.length; i++) {
			{
				int temp = is[index];
				is[index] = is[i];
				is[i] = temp;
			}
			f(is, index + 1);
			{
				int temp = is[index];
				is[index] = is[i];
				is[i] = temp;
			}
		}

	}
}
