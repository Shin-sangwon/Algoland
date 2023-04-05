import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int x;
		int y;
		int time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
				
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int[] dx = {1, 0, -1, 0};
		final int[] dy = {0, 1, 0, -1};
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][m];
		boolean[][] visited = new boolean[n][m];
		int[][] waterMap = new int[n][m];
		
		Queue<Node> water = new ArrayDeque<>();
		Queue<Node> queue = new ArrayDeque<>();
		
		int answer = -1;
		int targetX = -1;
		int targetY = -1;
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'S') {
					queue.add(new Node(i, j, 1));
					visited[i][j] = true;
					continue;
				}
				if(map[i][j] == '*') {
					water.add(new Node(i, j, 1));
					waterMap[i][j] = 1;
					continue;
				}
				if(map[i][j] == 'D') {
					targetX = i;
					targetY = j;
				}
				
			}
		}
		
		//water spread
		
		while(!water.isEmpty()) {
			
			Node node = water.poll();
			
			for(int k = 0; k < 4; k++) {
				int nx = dx[k] + node.x;
				int ny = dy[k] + node.y;
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(waterMap[nx][ny] != 0) continue;
				
				if(map[nx][ny] == 'X') continue;
				
				if(map[nx][ny] == 'D') continue;
				
				water.add(new Node(nx, ny, node.time + 1));
				waterMap[nx][ny] = node.time + 1;
			}
		}
		
		// start
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			if(node.x == targetX && node.y == targetY) {
				answer = node.time - 1;
				break;
			}
			
			for(int k = 0; k < 4; k++) {
				int nx = dx[k] + node.x;
				int ny = dy[k] + node.y;
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == 'X') continue;
				
				if(node.time + 1 >= waterMap[nx][ny] && waterMap[nx][ny] != 0) continue;
				
				queue.add(new Node(nx, ny, node.time + 1));
				visited[nx][ny] = true;
			}
		}
		System.out.println(answer == -1 ? "KAKTUS" : answer);
	}

}
