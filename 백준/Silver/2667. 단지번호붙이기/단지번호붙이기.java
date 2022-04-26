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
		//사이즈 넣을 동적배열 생성 및 기본세팅
		ArrayList<Integer> ans = new ArrayList<>();
		int cnt = Integer.parseInt(br.readLine());
		int arr[][] = new int[cnt][cnt];
		boolean visited[][] = new boolean[cnt][cnt];
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		//2차원배열로 입력받기
		for(int i = 0; i < cnt; i++) {
			String str = br.readLine();
			for(int j = 0; j < cnt; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j, j+1));
			}		
		}
		
		Queue<Node> q = new LinkedList<>();
		
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < cnt; j++) {
				if(arr[i][j] == 0 || visited[i][j] == true) {
					continue;
				}
				
				q.add(new Node(i, j));
				visited[i][j] = true;
				int size = 0;
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					size++;
					for(int k = 0; k < 4; k++) {
						int nx = dx[k] + node.x;
						int ny = dy[k] + node.y;
						if(nx < 0 || ny < 0 || nx >= cnt || ny >= cnt) {
							continue;
						}
						if(arr[nx][ny] == 1 && visited[nx][ny] == false) {
							q.add(new Node(nx, ny));
							visited[nx][ny] = true;
						}
						
					}
				}
				//단지수 저장
				ans.add(size);
			}
		}	
		Collections.sort(ans); 	//내림차순 정렬 위해 오름차순정렬
		System.out.println(ans.size()); // 총 단지수(배열 사이즈) 출력
		for(int x : ans) System.out.println(x);		
	}

}