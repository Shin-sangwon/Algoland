import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][m];
		boolean visited[][] = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int dy[] = {1, 0, -1, 1, -1, 1, 0, -1};
		int ans = 0;
		Queue<Node> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0 || visited[i][j] == true) {
					continue;
				}
				
				ans++;
				q.add(new Node(i, j));
				visited[i][j] = true;
				while(!q.isEmpty()) {
					Node node = q.poll();
					for(int k = 0; k < dx.length; k++) {
						int nx = node.x + dx[k];
						int ny = node.y + dy[k];
						if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
							continue;
						}
						
						if(arr[nx][ny] == 1 && visited[nx][ny] == false) {
							q.add(new Node(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}
}