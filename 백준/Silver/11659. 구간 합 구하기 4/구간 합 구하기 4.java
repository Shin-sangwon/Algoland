import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[100001];
		int dp[] = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i-1] + arr[i];
		}
		
		while(cnt != 0) {
			cnt--;
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(dp[j] - dp[i-1]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
	}
			
}