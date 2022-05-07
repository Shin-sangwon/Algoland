import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static boolean checker[] = new boolean[26];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static char arr[][];
	static int n,m;
	static int size = 1;
	static int ans = 1;
	
	
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}
	
	static void dfs(int x, int y) {
		
		checker[arr[x][y] - 65] = true;
		for(int k = 0; k < 4; k++) {
			int nx = dx[k] + x;
			int ny = dy[k] + y;
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}
				
			if(checker[arr[nx][ny] - 65] == false) {
				size++;
				ans = Math.max(size, ans);
				dfs(nx,ny);
			}
		}	
		size--; checker[arr[x][y] - 65] = false; 		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		
		
		for(int i = 0 ; i < n; i++) {
			char tmp[] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				arr[i][j] = tmp[j];
			}
		}
		
		dfs(0,0);
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
		
	}

}