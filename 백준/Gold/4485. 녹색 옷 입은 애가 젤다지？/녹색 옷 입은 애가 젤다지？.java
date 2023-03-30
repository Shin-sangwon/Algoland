import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dx = {1, 0, -1 , 0 };
	static final int[] dy = {0, 1, 0, -1};
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int weight;
		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
		
			return this.weight - o.weight;
		}

		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int printIndex = 1;
		
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];
			
			for(int[] x : dist) {
				Arrays.fill(x, (int) 1e9);
			}
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dist[0][0] = map[0][0];
			PriorityQueue<Node> queue = new PriorityQueue<>();
			queue.add(new Node(0, 0, map[0][0]));	
			// 돌기
			
			while(!queue.isEmpty()) {
				
				Node node = queue.poll();

				for(int k = 0; k < 4; k++) {
					int nx = dx[k] + node.x;
					int ny = dy[k] + node.y;
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					
					if(dist[nx][ny] <= dist[node.x][node.y] + map[nx][ny]) continue;
					
					dist[nx][ny] = dist[node.x][node.y] + map[nx][ny];
					queue.add(new Node(nx, ny, dist[nx][ny]));
					
					
				}
				
			}
			
			sb.append(String.format("Problem %d: %d\n", printIndex++, dist[n-1][n-1]));
			
		}
		
		System.out.println(sb);
	}

}
