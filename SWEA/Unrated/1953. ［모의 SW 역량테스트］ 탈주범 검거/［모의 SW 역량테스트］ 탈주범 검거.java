import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int dx[] = {1, -1, 0, 0}; // 상 하 좌 우 
	static int dy[] = {0, 0, -1, 1};
	static List<int[][]> dir = new ArrayList<>();
	static int n, m, r, c, l, answer, map[][], visited[][];
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;	
		}
	}
	
	private static void init() {
		// 쓰레기값
		dir.add(new int[1][1]);
		//1. 상하좌우
		dir.add(new int[][]{{-1, 0}, {1, 0}, {0, -1} , {0, 1}});
		//2. 상하
		dir.add(new int[][] {{-1, 0}, {1, 0}});
		//3. 좌우
		dir.add(new int[][] {{0, -1}, {0, 1}});
		//4. 상우
		dir.add(new int[][] {{-1, 0}, {0, 1}});
		//5. 하우
		dir.add(new int[][] {{1, 0}, {0, 1}});
		//6. 하좌
		dir.add(new int[][] {{1, 0}, {0, -1}});
		//7. 상좌
		dir.add(new int[][] {{-1, 0}, {0, -1}});
		
		
	}
	
	private static boolean check(int idx, int nextIdx, int direction) {
		
		//1 -> 전부 방문가능
		//2 -> 3 불가능, 4 -> 2가 위쪽에 있을때만 가능, 5 -> 2가 아래일때만 가능, 6-> 2가 아래일때만 가능, 7 -> 2가 위일때만 가능
		
		if(idx == 1) {
			
			if(nextIdx == 2) {
				
				if(direction == 2 || direction == 3) return false;
			}
			
			if(nextIdx == 3) {
				
				if(direction == 0 || direction == 1) return false;
			
			}
			
			if(nextIdx == 4) {
				
				if(direction == 0 || direction == 3) return false;
			}
			
			if(nextIdx == 5) {
				
				if(direction == 1 || direction == 3) return false;
			}
			
			if(nextIdx == 6) {
				
				if(direction == 1 || direction == 2) return false;
			}
			
			if(nextIdx == 7) {
				
				if(direction == 0 || direction == 2) return false;
			}
		}
		
		if(idx == 2) {
			
			if(nextIdx == 3) return false;
			
			if(nextIdx == 4 || nextIdx == 7) {
				
				if(direction == 0) return false;
			}
			
			if(nextIdx == 5 || nextIdx == 6) {
				
				if(direction == 1) return false;
			}
					
		}
		
		if(idx == 3) {
			
			if(nextIdx == 2) return false;
			
			if(nextIdx == 4 || nextIdx == 5) {
				
				if(direction == 1) return false;
			}
			
			if(nextIdx == 6 || nextIdx == 7) {
				
				if(direction == 0) return false;
			}
		}
		
		if(idx == 4) {
			
			if(nextIdx == 2 || nextIdx == 5) {
				
				if(direction == 1) return false;
				
			}
			
			if(nextIdx == 3 || nextIdx == 7) {
				
				if(direction == 0) return false;
			}
			
			if(nextIdx == 4) return false;
			
			
		}
		
		if(idx == 5) {
			
			if(nextIdx == 2 || nextIdx == 4) {
				
				if(direction == 1) return false;
			}
			
			if(nextIdx == 3 || nextIdx == 6) {
				
				if(direction == 0) return false;
			}
			
			if(nextIdx == 5) return false;
			
			
		}
		
		if(idx == 6) {
			
			if(nextIdx == 2 || nextIdx == 7) {
				
				if(direction == 1) return false;
			}
			
			if(nextIdx == 3 || nextIdx == 5) {
				
				if(direction == 0) return false;
			}
			
			if(nextIdx == 6) return false;
		}
		
		if(idx == 7) {
			
			if(nextIdx == 2 || nextIdx == 6) {
				
				if(direction == 1) return false;
			}
			
			if(nextIdx == 3 || nextIdx == 4) {
				
				if(direction == 0) return false;
			}
			
			if(nextIdx == 7) return false;
			
			
		}
		
		
		
		return true;
	}
	
	private static void bfs() {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c));
		visited[r][c] = 1;
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			int idx = map[node.x][node.y];
			
			int[][] direction = dir.get(idx);
			
			for(int i = 0; i < direction.length; i++) {
				
				int nx = node.x + direction[i][0];
				int ny = node.y + direction[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(map[nx][ny] == 0) continue;
				
				if(visited[nx][ny] != 0) continue;
				
				if(!check(idx, map[nx][ny], i)) continue;
				
				queue.add(new Node(nx, ny));
				visited[nx][ny] = visited[node.x][node.y] + 1;
				
			}
		}
		
		
		calc();
		
	}
	
	private static void calc() {
		
		for(int[] x : visited) {
			for(int y : x) {
				if(y > 0 && y < l+1) answer++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		int printIndex = 1;
		for(int i = 0; i <= 7; i++) {
			dir = new ArrayList<>();
		}
		
		init();
		
		while(tc-->0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //세로 크기
			m = Integer.parseInt(st.nextToken()); //가로 크기
			r = Integer.parseInt(st.nextToken()); //멘홀 세로
			c = Integer.parseInt(st.nextToken()); //멘홀 가로
			l = Integer.parseInt(st.nextToken()); //탈출 후 소요된 시간
			
			map = new int[n][m];
			visited = new int[n][m];
			answer = 0;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			sb.append(String.format("#%d %d\n", printIndex++, answer));
			
			
		}
		
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
