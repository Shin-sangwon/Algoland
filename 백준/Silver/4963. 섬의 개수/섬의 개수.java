import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static int dx[] = {1, 0, -1, 0, -1, 1, -1, 1};
	static int dy[] = {0, 1, 0, -1, 1, 1, -1, -1};
	static int n,m;
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	static int dfs(int arr[][]) {
		boolean visited[][] = new boolean[m][n];
		int num = 0;
		Queue<Node> q = new LinkedList<>();
		
	
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 0 || visited[i][j] == true) {
					continue;
				}
				
				q.add(new Node(i,j));
				visited[i][j] = true;
				num++;
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					for(int k = 0; k < 8; k++) {
						int nx = dx[k] + node.x;
						int ny = dy[k] + node.y;
						if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
							continue;
						}
						if(arr[nx][ny] == 1 && visited[nx][ny] == false) {
							q.add(new Node(nx,ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[][];
		StringTokenizer st;
		
		Loop1:
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) break Loop1;
			
			arr = new int[m][n];
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.write(dfs(arr)+""+'\n');
						
		}
		
		bw.flush();
		bw.close();
	}

}