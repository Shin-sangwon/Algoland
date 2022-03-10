import java.util.*;
import java.math.*;


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int arr[] = new int[cnt+1];
		int dp[] = new int[cnt+1];
		for(int i = 1; i < cnt+1; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		if(cnt < 3) {
			for(int x : arr) ans += x;
		}else {
			dp[1] = arr[1]; dp[2] = dp[1] + arr[2];
			for(int i = 3; i < cnt+1; i++) {
				dp[i] = dp[i-1];
				dp[i] = Math.max(dp[i], Math.max(arr[i] + dp[i-2], arr[i] + arr[i-1] + dp[i-3]));
			}
			ans = dp[cnt];
		}
		System.out.println(ans);
	}
}