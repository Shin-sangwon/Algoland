import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int arr[][];
	static int n;
	static int m;
	
	//노드클래스
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	//빙하 녹는 메소드
	public static int[][] melting(int arr[][]){
		int tmp[][] = new int[n][m];		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int cnt = 0;
				for(int k = 0; k < 4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
						continue;
					}
					
					if(arr[nx][ny] == 0) cnt++;					
				}
				tmp[i][j] = cnt;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] -= tmp[i][j];
				if(arr[i][j] < 0) arr[i][j] = 0;
			}
		}		
		return arr;
	}
	
	//모두 녹을 때 까지 분리 안 됐을 때
	public static boolean checker(int arr[][]) {
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] != 0) {
					count += 1;
				}
			}
		}
		
		if(count != 0) return false;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		boolean flag = true;
		int ans = 0;				
		while(flag) {
			Queue<Node> q = new LinkedList<>();
			int num = 0;
			boolean visited[][] = new boolean[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j] == 0 || visited[i][j] == true) {
						continue;
					}
					q.add(new Node(i,j));
					visited[i][j] = true;
					num++;
					while(!q.isEmpty()) {
						Node node = q.poll();
						for(int k = 0; k < 4; k++) {
							int nx = dx[k] + node.x;
							int ny = dy[k] + node.y;
							if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
								continue;
							}
							if(arr[nx][ny] != 0 && visited[nx][ny] == false) {
								q.add(new Node(nx, ny));
								visited[nx][ny] = true;
							}							
						}
					}
				}
			}
			if(num >= 2) {
				bw.write(String.valueOf(ans));
				flag = false;
			}else if(checker(arr)){
				bw.write(String.valueOf(0));
				flag = false;
			}else {
				ans++;
				melting(arr);
			}
		}
		bw.flush();
		bw.close();
	}

}