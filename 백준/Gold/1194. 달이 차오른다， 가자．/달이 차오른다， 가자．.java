import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	
	static class Node{
		int x;
		int y;
		int time;
		int bit;
		
		public Node(int x, int y, int time, int bit) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.bit = bit;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][m];
		boolean[][][] visited = new boolean[n][m][1<<6];
		Queue<Node> queue = new LinkedList<>();
		int answer = -1;
		
		// 0 -> 현재 위치, 1 -> 탈출구, 소문자 -> 열쇠 대문자 -> 열쇠가 있어야 함
		// 'a' -> 97 'A' -> 65
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '0') {
					queue.add(new Node(i, j, 0, 0));
					visited[i][j][0] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(map[node.x][node.y] == '1') {
				answer = node.time;
				break;
			}
			
			for(int k = 0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(visited[nx][ny][node.bit]) continue;
				
				if(map[nx][ny] == '#') continue;
				//doors
				if((map[nx][ny] >= 65 && map[nx][ny] <= 70) && (node.bit & (1 << map[nx][ny] - 65)) == 0) continue;
				
				//keys
				if(map[nx][ny] >= 97 && map[nx][ny] <= 102) {
					int bit =  node.bit | (1 << map[nx][ny] - 97);
					visited[nx][ny][bit] = true;
					queue.add(new Node(nx, ny, node.time + 1, bit));
				}
			
				queue.add(new Node(nx, ny, node.time + 1, node.bit));
				visited[nx][ny][node.bit] = true;
	
			}
		}
		
		System.out.println(answer);
	}

}
