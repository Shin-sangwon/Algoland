import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	static int m, n;
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
	
	private static boolean isEscape(Node node) {
		
		if(node.x == 0 || node.x == n-1 || node.y == 0 || node.y == m-1) return true;
		
		return false;
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		char[][] map;
		int[][] fireMap;
		boolean[][] visited;
		Queue<Node> queue;
		Queue<Node> fire;
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			fireMap = new int[n][m];
			visited = new boolean[n][m];
			queue = new LinkedList<>();
			fire = new LinkedList<>();
			int answer = -1;
			for(int[] x : fireMap) Arrays.fill(x,  -1);
			
			for(int i = 0; i < n; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j = 0; j < m; j++) {
					map[i][j] = tmp[j];
					if(map[i][j] == '*') {
						fire.add(new Node(i, j, 0));
						visited[i][j] = true;
					}
					
					if(map[i][j] == '@') {
						queue.add(new Node(i, j, 0));
					}
				}
			}
			
			
			
			
			while(!fire.isEmpty()) {
				
				Node node = fire.poll();
				
				for(int k = 0; k < 4; k++) {
					int nx = node.x + dx[k];
					int ny = node.y + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					
					if(map[nx][ny] == '#') continue;
					
					if(visited[nx][ny]) continue;
					
					fire.add(new Node(nx, ny, node.time + 1));
					visited[nx][ny] = true;
					fireMap[nx][ny] = node.time + 1;
					
				}
			}
			
			visited = new boolean[n][m];
			Node start = queue.peek();
			visited[start.x][start.y] = true;	
			
			while(!queue.isEmpty()) {
				
				Node node = queue.poll();
				
				if(isEscape(node)) {
					answer = node.time;
					break;
				}
				
				for(int k = 0; k < 4; k++) {
					int nx = node.x + dx[k];
					int ny = node.y + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					
					if(visited[nx][ny]) continue;
					
					if(fireMap[nx][ny] <= node.time+1 && fireMap[nx][ny] != -1) continue;
					
					if(map[nx][ny] == '#' || map[nx][ny] == '*') continue;
					
					queue.add(new Node(nx, ny, node.time + 1));
					visited[nx][ny] = true;
						
				}
				
			}
			
			sb.append(answer == -1? "IMPOSSIBLE" : String.valueOf(answer+1)).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
