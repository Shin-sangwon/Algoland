import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		int dp[] = new int[1001];
		dp[1] = 1; dp[2] = 2;
		
		for(int i = 3; i <= cnt; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[cnt]);
		
	}
			
}