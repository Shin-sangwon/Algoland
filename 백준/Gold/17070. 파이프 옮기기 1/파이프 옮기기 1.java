import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//0 -> 가로, 1 -> 대각, 2 -> 세로
		int dp[][][] = new int[n][n][3];
		
		for(int i = 1; i < n; i++) {
			if(map[0][i] == 1) break;
		
			dp[0][i][0] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 2; j < n; j++) {
				
				if(map[i][j] == 0) {
					//가로
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
					//세로								
					dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
					//대각
					if(map[i-1][j] == 0 && map[i][j-1] == 0) dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];

				}
					
			}
		}
		
		int answer = 0;
		for(int k = 0; k < 3; k++) {
			answer += dp[n-1][n-1][k];
		}
		
		System.out.println(answer);
	}

}
