import java.util.*;
import java.math.*;
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//테스트케이스 수
		int cnt = Integer.parseInt(br.readLine());
		
		//나이트가 이동 가능한 좌표
		int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
		int dy[] = {1, -1, 2, -2, 2, -2, 1, -1};
		
		
		while(cnt-- != 0) {
			//입력받기, 초기세팅
			int size = Integer.parseInt(br.readLine());
			int arr[][] = new int[size][size];
			boolean visited[][] = new boolean[size][size];
			st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());
			
			Queue<Node> q = new LinkedList<>();
			arr[startX][startY] = 1;
			visited[startX][startY] = true;
			q.add(new Node(startX, startY));
			//타겟을 방문 할 때까지
			while(visited[targetX][targetY] == false) {
				while(!q.isEmpty()) {
					Node node = q.poll();
					for(int i = 0; i < dx.length; i++) {
						int nx = dx[i] + node.x;
						int ny = dy[i] + node.y;
						//예외처리
						if(nx < 0 || ny < 0 || nx >= size || ny >= size) {
							continue;
						}
						//방문하지 않은곳이라면, 전 단계의 횟수+1을해주고 큐에추가
						if(visited[nx][ny] == false) {
							visited[nx][ny] = true;
							arr[nx][ny] = arr[node.x][node.y] + 1;
							q.add(new Node(nx, ny));
						}						
					}
				}
			}
			//시작을 1로했으므로 -1을 해줘야함
			bw.write(String.valueOf(arr[targetX][targetY]-1));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
