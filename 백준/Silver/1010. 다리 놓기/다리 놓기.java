import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static int dp[][];
	
	static int combi(int n, int m) {
		if(dp[n][m] > 0) return dp[n][m];
		if(n == m || m == 0) return 1;
		else return dp[n][m] = combi(n-1, m-1) + combi(n-1, m);		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dp = new int[33][33];
		
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(cnt-- != 0) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			
			int n = Math.max(tmp1, tmp2);
			int m = Math.min(tmp1, tmp2);
			
			bw.write(combi(n,m)+""+'\n');			
		}		
		bw.flush();
		bw.close();
		
	}

}