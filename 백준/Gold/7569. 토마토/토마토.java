import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, h, arr[][][];
	static int[] dx = {1, 0, -1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	
	static class Node{
		int x;
		int y;
		int h;
		public Node(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	
	private static boolean calc() {
		
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				
				for(int j = 0; j < m; j++) {
					if(arr[i][j][k] == 0) return false;
				}
			}
			
		}
		
		return true;
	}
	
	private static int findAnswer() {
		
		int tmp = Integer.MIN_VALUE;
		
		for(int[][] x : arr) {
			for(int[] y : x) {
				for(int z : y) {
					if(z > tmp) tmp = z;
				}
			}
		}
		
		return tmp - 1;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h= Integer.parseInt(st.nextToken());
		
		arr = new int[n][m][h];
		boolean[][][] visited = new boolean[n][m][h];
		Queue<Node> queue = new LinkedList<>();
		
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 1) {
						queue.add(new Node(i, j, k));
						visited[i][j][k] = true;
					}
					
				}
			}
			
		}
		
		int answer = 0;
		
		if(calc()) {
			System.out.println(answer);
			return;
		}
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			for(int k = 0; k < 6; k++) {
				
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];		
				int nh = node.h + dh[k];
					
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || nh < 0 || nh >= h) continue;
				if(visited[nx][ny][nh]) continue;
				if(arr[nx][ny][nh] == -1) continue;
				
				arr[nx][ny][nh] = arr[node.x][node.y][node.h] + 1;
				visited[nx][ny][nh] = true;
				queue.add(new Node(nx, ny, nh));
					
				
			}
		}
		
		
		System.out.println(calc()? findAnswer() : -1);

	}

}
