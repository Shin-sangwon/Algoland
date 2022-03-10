import java.util.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 int cnt = sc.nextInt();
		 int arr[] = new int[cnt];
		 int dp[] = new int[cnt];
		 for(int i = 0; i < cnt; i++) {
			 arr[i] = sc.nextInt();
		 }
		 Arrays.sort(arr);
		 dp[0] = arr[0]; int ans = arr[0];
		 
		 for(int i = 1; i < cnt; i++) {
			 dp[i] = arr[i] + dp[i-1];
			 ans += dp[i];
		 }
		 
		 System.out.println(ans);
		 
	}

}