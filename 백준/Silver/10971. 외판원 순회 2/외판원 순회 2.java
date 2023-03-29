import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, answer, numbers[], map[][];
	static boolean visited[];
	
	private static void dfs(int cnt) {
		
		if(cnt == n) {
			int tmp = 0;
			for(int i = 0; i < n-1; i++) {
				
				if(map[numbers[i]][numbers[i+1]] == 0) return;
				
				tmp += map[numbers[i]][numbers[i+1]];
			}
			
			if(map[numbers[n-1]][numbers[0]] == 0) return;
			
			tmp += map[numbers[n-1]][numbers[0]];
			answer = Math.min(answer, tmp);
			return;
		}
		// 1, 2 , 3, 0
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			numbers[cnt] = i;
			visited[i] = true;
			dfs(cnt + 1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		
		map = new int[n][n];
		visited = new boolean[n];
		numbers = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(answer);
		
	}

}
