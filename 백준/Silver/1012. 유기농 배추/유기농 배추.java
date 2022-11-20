import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	//x, y좌표 클래스
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
		
		// 테스트케이스 수와 좌표 입력받기
		int cnt = Integer.parseInt(br.readLine());
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		
		//테스트케이스만큼 while문 돌기
		while(cnt != 0) {
			cnt--; // while문 탈출 조건
			
			//입력받고 기본 셋팅
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			int arr[][] = new int[n][m];
			boolean checker[][] = new boolean[n][m];
			Queue<Node> q = new LinkedList<>();
			
			//배추 위치 입력받기
			for(int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[b][a] = 1;
			}
			
			//탐색 시작
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j] == 0 || checker[i][j] == true) {
						continue;
					}
					
					ans++; // 필요한 지렁이 갯수
					q.add(new Node(i, j));
					checker[i][j] = true;
					while(!q.isEmpty()) {
						Node node = q.poll();
						for(int k = 0; k < 4; k++) {
							int nx = node.x + dx[k];
							int ny = node.y + dy[k];
							
							if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
								continue;
							}
							
							if(arr[nx][ny] == 1 && checker[nx][ny] == false) {
								q.offer(new Node(nx, ny));
								checker[nx][ny] = true;
							}
						}
					}					
				}			
			}	
			System.out.println(ans);
		}
	}

}