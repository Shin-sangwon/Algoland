import java.util.*; import java.math.*;


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		int dp[] = new int[11];
		
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		for(int i = 0; i < cnt; i++) System.out.println(dp[sc.nextInt()]);
	}

}
