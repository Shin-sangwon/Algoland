import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int k, n, m, map[][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] horseX = {1, -1, 2, -2, 2, -2, 1, -1};
	static int[] horseY = {-2, -2, -1, -1, 1, 1, 2, 2};
	static boolean visited[][][];
	
	static class Node{
		int x;
		int y;
		int k;
		int count;
		public Node(int x, int y, int k, int count) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m][k+1];
		visited[0][0][0] = true;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = -1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.x == n-1 && node.y == m-1) {
				answer = node.count;
				break;
			}
			
			if(node.k < k) {
				
				for(int k = 0; k < 8; k++) {
					int nx = horseX[k] + node.x;
					int ny = horseY[k] + node.y;
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					
					if(visited[nx][ny][node.k + 1]) continue;
					
					if(map[nx][ny] == 1) continue;
					
					visited[nx][ny][node.k + 1] = true;
					queue.add(new Node(nx, ny, node.k + 1, node.count + 1));
					
				}
			}
			
			for(int k = 0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(visited[nx][ny][node.k]) continue;
				
				if(map[nx][ny] == 1) continue;
				
				visited[nx][ny][node.k] = true;
				queue.add(new Node(nx, ny, node.k, node.count + 1));
			}
		}
		
		System.out.println(answer);
	}

}
