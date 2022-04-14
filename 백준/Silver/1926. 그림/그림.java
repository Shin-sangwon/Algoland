import java.io.*;
import java.util.*;

public class Main {
	
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
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력값 셋팅
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][m];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//방문처리, 큐, 최대값, 그림의 갯수, 크기 셋팅
		boolean visited[][] = new boolean[n][m];
		Queue<Node> q = new LinkedList<>();
		ArrayList<Integer> maxValue = new ArrayList<>();
		
		int num = 0;
		int size = 0;
		//그림이 없을 시 0을 출력하기 위해 0 삽입
		maxValue.add(0);
		
		//좌표셋팅
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		
		for(int i = 0; i < n; i++) {			
			for(int j = 0; j < m; j++) {
				//그림이 아니거나 방문했으면 건너뛰기
				if(arr[i][j] == 0 || visited[i][j] == true) {
					continue;
				}
				//예외처리 후에 그림의 갯수 더해주고 좌표, 방문기록 추가 후 size 초기화
				num++;
				q.add(new Node(i, j));
				visited[i][j] = true;
				//size 0으로 초기화
				size = 0;
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					size++;
					for(int k = 0; k < 4; k++) {
						int nx = node.x + dx[k];
						int ny = node.y + dy[k];
						//좌표가 범위를 넘어갈때의 예외처리
						if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
							continue;
						}
						//그림이고 방문을 하지 않았다면 큐와 방문기록 추가
						if(arr[nx][ny] == 1 && visited[nx][ny] == false) {
							q.offer(new Node(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
				//최대값 구하기 위해 추가
				maxValue.add(size);				
			}
		}
		
		//최대값을 구하기 위해 내림차순 정렬 / 0을 추가해놨기에 그림이 없다면 자동으로 0이 출력됨.
		Collections.sort(maxValue, Collections.reverseOrder());
		
		System.out.println(num);
		System.out.println(maxValue.get(0));
					
	}

}