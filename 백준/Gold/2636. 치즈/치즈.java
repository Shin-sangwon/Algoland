import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	static int n,m;
	static boolean[][] map;
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean[][] copy() {
		boolean[][] of = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j]) of[i][j] = true;
			}
		}
		
		return of;
	}
	
	private static int countCheese(boolean[][] arr) {
		
		int res = 0;
		
		for(boolean[] x : arr) {
			for(boolean y : x) {
				if(y) res++;
			}
		}
		
		return res;
	}
	
	private static void bfs() {
		boolean[][] copyMap = copy();
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		queue.add(new Node(0, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int k = 0; k < 4; k++) {
				
				int nx = dx[k] + node.x;
				int ny = dy[k] + node.y;
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(visited[nx][ny]) continue;
				//겉면이면 녹여주기
				if(map[nx][ny]) {
					copyMap[nx][ny] = false;
					continue;
				}
				
				visited[nx][ny] = true;
				queue.add(new Node(nx, ny));
			}
		}
		
		map = copyMap;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				if(tmp == 1) map[i][j] = true;
			} 
		}
		
		int count = 0;
		int answer = 0;
		
		while(true) {
			
			if(countCheese(map) == 0) {
				break;
			}
			
			count++;
			answer = countCheese(map);
			bfs();
			
			
		}
		
		sb.append(count + "\n" + answer);
		System.out.println(sb);
	}
	
}
