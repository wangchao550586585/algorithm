
public class 参赛可能性 {
	private static String[] arr = { "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J" };

	public static void main(String[] args) {
		int isVisited[] = new int[arr.length];
		fun(0, isVisited);

	}
	private static void fun(int inde, int[] isVisited) {

		if (inde == arr.length) {
			if (f(isVisited)) {
				for (int i = 0; i < arr.length; i++) {
					if (isVisited[i] == 1)
						System.out.print(arr[i]);
				}
				System.out.println();
			}
			return;
		}

		isVisited[inde] = 0;
		fun(inde + 1, isVisited);

		isVisited[inde] = 1;
		fun(inde + 1, isVisited);
	}
	private static boolean f(int[] x) {
		boolean[] check = new boolean[x.length];
		check[0] = x[0] == 0 || x[1] == 1;
		check[1] = x[2] == 1 || x[3] == 0;
		check[2] = (x[0] + x[2]) <= 1;
		check[3] = (x[1] + x[3]) == 1;
		check[4] = (x[3] + x[4] + x[5] + x[6] + x[7]) >= 2;
		check[5] = (x[2] + x[6]) == 2 || (x[2] + x[6]) == 0;
		check[6] = (x[2] + x[4] + x[6] + x[8]) <= 2;
		check[7] = x[4] == 0 || x[5] + x[6] == 2;
		check[8] = x[5] == 0 || x[6] + x[7] == 0;
		check[9] = x[8] + x[9] >0 || x[7] == 1;
		return check[0] && check[1] && check[2] && check[3] && check[4]
				&& check[5] && check[6] && check[7] && check[8] && check[9];
	}
	
}
