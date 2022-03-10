import java.util.*;
import java.math.*;


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int arr[] = new int[cnt+1];
		for(int i = 1; i <= cnt; i++) arr[i] = sc.nextInt();
		int dp[] = new int[cnt+1];
		if(cnt == 1) {
			System.out.println(arr[1]);
		}else if(cnt == 2) {
			System.out.println(arr[1] + arr[2]);
		}else {
			dp[1] = arr[1]; dp[2] = arr[1] + arr[2];
			for(int i = 3; i <= cnt; i++) {
				dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i] + arr[i-1]);
			}
			System.out.println(dp[cnt]);
		}
		
		
	}
}