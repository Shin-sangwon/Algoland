import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 아래 오른쪽으로만 가보기
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n,m;
	
	static class Node{
		int x;
		int y;
		int time;
		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	private static boolean isEscape(Node node) {
		
		return (node.x == 0 || node.x == n-1 || node.y == 0 || node.y == m-1);
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][];
		Queue<Node> fire = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		
		int[][] fireMap = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int[] x : fireMap) {
			Arrays.fill(x, -1);
		}
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'J') {
					queue.add(new Node(i, j, 1));
				}
				if(map[i][j] == 'F') {
					fire.add(new Node(i, j, 1));
					fireMap[i][j] = 1;
					visited[i][j] = true;
				}
			}
		}
		
		
		//불 퍼트리기
		while(!fire.isEmpty()) {
			Node node = fire.poll();
			
			for(int k = 0; k < 4; k++) {
				int nx = dx[k] + node.x;
				int ny = dy[k] + node.y;
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(map[nx][ny] == '#') continue;
				
				if(visited[nx][ny]) continue;
				
				fireMap[nx][ny] = node.time + 1;
				visited[nx][ny] = true;
				fire.add(new Node(nx, ny, node.time + 1));
			}
		}
		
		int answer = -1;
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
				int nx = dx[k] + node.x;
				int ny = dy[k] + node.y;
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
				
				if(fireMap[nx][ny] <= node.time + 1 && fireMap[nx][ny] != -1) continue;
				
				visited[nx][ny] = true;
				queue.add(new Node(nx, ny, node.time + 1));
				
			}
		}
		
		System.out.println(answer == -1? "IMPOSSIBLE" : answer);
	}

}
