import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int n = Integer.parseInt(br.readLine());
		
		//혹시 모르니 long으로 ..
		long ans = 0;
		
		//
		int dp[][] = new int[n+1][10];
		
		for(int i = 1; i <= 1; i++) {
			for(int j = 0; j < 10; j++) {
				dp[i][j] = 1;
			}
		}
		
		for(int i = 2; i <= n; i++) {
			int tmp = 0;
			for(int j = 9; j >= 0; j--) {
				dp[i][j] = (dp[i-1][j] + tmp) % 10007;
				tmp = (tmp + dp[i-1][j]) % 10007;
				
			}
		}
		
		for(int i = 0; i <= 9; i++) {
			ans += dp[n][i];
		}
		
		bw.write(ans%10007+"");
		bw.flush();
		bw.close();
		
	}
}