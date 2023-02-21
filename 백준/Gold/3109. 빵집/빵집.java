import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static int n,m, answer;
	static char[][] arr;
	static boolean checker, visited[][];
	
	static class Node{
		
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void bfs(int x, int y) {
		
		if(y == m - 1) {
			checker = true;
			answer++;
			return;
		}
		
		for(int k = 0; k < 3; k++) {
			
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			
			if(visited[nx][ny]) continue;
			
			if(arr[nx][ny] == 'x') continue;
			
			visited[nx][ny] = true;
			
			bfs(nx, ny);
			
			if(checker) {
				return;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		visited = new boolean[n][m];
		answer = 0;
		
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {	
			checker = false;
			bfs(i, 0);
		}
		
		System.out.println(answer);
		
		

	}

}
