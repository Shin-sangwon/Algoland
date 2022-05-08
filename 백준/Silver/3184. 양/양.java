import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
		 this.x = x;
		 this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[n][m];
		boolean visited[][] = new boolean[n][m];
		//o는 양, v는 늑대, 같은영역에서 우세한 종만 살아남음
		int wolves = 0;
		int sheep = 0;
		
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		
		for(int i = 0; i < n; i++) {
			char tmp[] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				arr[i][j] = tmp[j];
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == '#' || visited[i][j] == true) {
					continue;
				}
				
				int tmpwolves = 0;
				int tmpsheep = 0;
				if(arr[i][j] == 'o') tmpsheep++;
				if(arr[i][j] == 'v') tmpwolves++;
				
				q.add(new Node(i,j));
				visited[i][j] = true;
				while(!q.isEmpty()) {	
					Node node = q.poll();
					for(int k = 0; k < 4; k++) {
						int nx = node.x + dx[k];
						int ny = node.y + dy[k];
						if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
							continue;
						}
						
						if(arr[nx][ny] !=  '#' && visited[nx][ny] == false) {
							q.add(new Node(nx, ny));
							visited[nx][ny] = true;
							if(arr[nx][ny] == 'o') tmpsheep++;
							if(arr[nx][ny] == 'v') tmpwolves++;
						}
					}				
				}
				if(tmpwolves < tmpsheep) {
					sheep += tmpsheep;
				}else {
					wolves += tmpwolves;
				}
			}
		}
		
		bw.write(sheep + " " + wolves);
		bw.flush();
		bw.close();
		
	}
}