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
		dp[0] = Integer.MIN_VALUE;
		dp[1] = arr[1];
		for(int i = 2; i <=cnt; i++) {
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
		}
		Arrays.sort(dp);
		System.out.println(dp[cnt]);
		
	}
}