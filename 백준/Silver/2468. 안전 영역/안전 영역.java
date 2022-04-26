import java.util.*;
import java.math.*;
import java.io.*;

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
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		int arr[][] = new int[cnt][cnt];
		int max = Integer.MIN_VALUE;
		int start = -1;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < cnt; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}		
		}
		
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		Queue<Node> q = new LinkedList<>();	
		
		while(start++ <= max) {
			int num = 0;
			boolean checker[][] = new boolean[cnt][cnt];
			for(int i = 0; i < cnt; i++) {
				for(int j = 0; j < cnt; j++) {
					if(arr[i][j] <= start) {
						arr[i][j] = 0;
					}
				}
			}
			
			for(int i = 0; i < cnt; i++) {
				for(int j = 0; j < cnt; j++) {
					if(arr[i][j] == 0 || checker[i][j] == true) {
						continue;
					}
					
					num++;
					q.add(new Node(i, j));
					checker[i][j] = true;
					
					while(!q.isEmpty()) {
						Node node = q.poll();
						for(int k = 0; k < 4; k++) {
							int nx = node.x + dx[k];
							int ny = node.y + dy[k];
							
							if(nx < 0 || ny < 0 || nx >= cnt || ny >= cnt) {
								continue;
							}
							
							if(arr[nx][ny] != 0 && checker[nx][ny] == false) {
								q.add(new Node(nx, ny));
								checker[nx][ny] = true;
							}
						}
					}
				}
			}
			
			ans.add(num);
			
		}
		
		Collections.sort(ans);
		bw.write(String.valueOf(ans.get(ans.size()-1)));
		bw.flush();
		bw.close();
	}
			
}
