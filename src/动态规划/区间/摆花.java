package 动态规划.区间;
import java.util.Scanner;

public class 摆花 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int result[][] = new int[n + 1][m + 1];
		for(int i=0;i<arr[1];i++){
			result[1][i]=1;
		}
		for(int i=2;i<=n;i++){
			for(int j=0;j<=m;j++){
				for(int k=0;k<=arr[i];k++ ){
					if(j>=k){
						result[i][j]=(result[i][j]+result[i-1][j-k])%10086;
					}
				}
			}
		}
		
		System.out.println(result[n][m]);
		
		
		
		
		
	}
}
