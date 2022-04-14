import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	public static class Node{
		
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// -1 빈칸 0 안익은토마토 1 토마토
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		
		//입력, 초기값 셋팅
		int arr[][] = new int[n][m];
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		Queue<Node> q = new LinkedList<>();
		int day = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) q.add(new Node(i, j));
			}
		}
		//===================================================
		//처음의 1을 전부 저장해서 반복문을 돌려야함 !!
		
		while(!q.isEmpty()) {
			for(int o = 0; o < q.size(); o++) {
			
			Node node = q.poll();
			for(int k = 0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					q.add(new Node(nx, ny));
					arr[nx][ny] = arr[node.x][node.y] + 1;					
				}
			}			
		}		
	}			
		//출력
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				day = Math.max(day, arr[i][j]);
			}
		}
		//최대숫자 -1이 다 익은 날짜
		System.out.println(day-1);
	}
}