import java.util.Scanner;
import java.math.*;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int ans = 0;
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1; i < n; i++) {
			int max = 0;
			for(int j = i-1; j >= 0; j--) {
				if(arr[i] > arr[j] && dp[j] > max) {
					max = dp[j];
				}
				dp[i] = max + 1;
				ans = Math.max(ans, dp[i]);
			}
		}

		if(n == 1) System.out.println(1);
		else System.out.println(ans);
		
	}

}
