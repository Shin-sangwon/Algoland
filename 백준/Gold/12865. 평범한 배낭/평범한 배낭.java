import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 개수
		int totalWeight = Integer.parseInt(st.nextToken()); // 한계 무게
		
		int[] weights = new int[n+1]; 
		int[] profits = new int[n+1];
		
		int[][] dp = new int[n+1][totalWeight + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) { // i : 물건
			for(int w = 1; w <= totalWeight; w++) { // w : 가방의 무게
				// 해당 물건의 무게가 w를 초과하는지
				if(weights[i] > w) {
					dp[i][w] = dp[i-1][w];
				}else {
					dp[i][w] = Math.max(dp[i-1][w], profits[i] + dp[i-1][w-weights[i]]);
				}
			}
		}
		
		System.out.println(dp[n][totalWeight]);
	}

}
