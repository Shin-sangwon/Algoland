import java.util.*;
import java.io.*;

public class Main {
	
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[n][3];
		//arr[0][0] = 1번집 빨강 arr[0][1] = 1번집 초록 arr[0][2] = 1번집 파랑
		int dp[][] = new int[n][3];
		for(int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());			
			}		
		}
		
		dp[0][0] = arr[0][0]; dp[0][1] = arr[0][1]; dp[0][2] = arr[0][2];
		
		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}
		
		int ans = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
}