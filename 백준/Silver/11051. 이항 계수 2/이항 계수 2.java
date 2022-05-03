import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static int dp[][];
	
	static int combi(int n, int m) {
		if(dp[n][m] > 0) return dp[n][m];
		
		if(n == m || m == 0) return 1;
		else return dp[n][m] = (combi(n-1, m-1) + combi(n-1, m)) % 10007;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		dp = new int[1001][1001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		bw.write(combi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "");
		bw.flush();
		bw.close();
	}

}