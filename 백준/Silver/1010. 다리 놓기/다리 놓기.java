import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int dp[][];
	
	static int combi(int n, int m) {
		if(dp[n][m] > 0) return dp[n][m];
		if(n == m || m == 0) return 1;
		else return dp[n][m] = combi(n-1, m-1) + combi(n-1, m);		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp = new int[33][33];
		
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(cnt-- != 0) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			
			int n = Math.max(tmp1, tmp2);
			int m = Math.min(tmp1, tmp2);
			
			sb.append(combi(n,m)).append("\n");			
		}		
		
			System.out.println(sb);

	}

}
