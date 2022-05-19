import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int arr1[][] = new int[n][2];
		int arr2[] = new int[n];
		int dp[] = new int[n+1]; dp[0] = 1;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j >= 0; j--) {
				arr1[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		Arrays.sort(arr1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0; i < n; i++) {
			arr2[i] = arr1[i][1];
		}
		
		for(int i = 0; i < n; i++) {
			int max = 0;
			for(int j = i-1; j >= 0; j--) {
				if(arr2[i] > arr2[j] && dp[j] > max) {
					max = dp[j];
				}
				dp[i] = max+1;
				ans = Math.max(ans, dp[i]);
			}
		}
		bw.write(n - ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}