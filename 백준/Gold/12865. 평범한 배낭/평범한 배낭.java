import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dp[] = new int[k+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			for(int j = k; j >= weight; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight] + value);
			}
		}
		
		bw.write(dp[k]+"");
		bw.flush();
		bw.close();
		
	}
}