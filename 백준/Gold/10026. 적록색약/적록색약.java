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
		
		//입력셋팅
		int cnt = Integer.parseInt(br.readLine());
		
		//arr1은 정상시야, arr2는 적록색약
		char arr1[][] = new char[cnt][cnt];
		char arr2[][] = new char[cnt][cnt];
		for(int i = 0; i < cnt; i++) {
			String str = br.readLine();
			for(int j = 0; j < cnt; j++) {
				char tmp = str.charAt(j);
				arr1[i][j] = tmp;
				arr2[i][j] = tmp;
			}
		}
		
		//arr2 Red로 통일
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < cnt; j++) {
				if(arr2[i][j] == 'G') {
					arr2[i][j] = 'R';
				}
			}
		}
		
		//정상시야, 적록색약 방문체크 배열
		boolean checker1[][] = new boolean[cnt][cnt];
		boolean checker2[][] = new boolean[cnt][cnt];
		//좌표셋팅
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		//정상시야, 적록색약 구역 설정
		int num1 = 0;
		int num2 = 0;
		//
		Queue<Node> q = new LinkedList<>();
		
		
		
		
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < cnt; j++) {
				if(checker1[i][j] == true) {
					continue;
				}
				
				num1++;
				q.add(new Node(i, j));
				checker1[i][j] = true;
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					for(int k = 0; k < 4; k++) {
						int nx = node.x + dx[k];
						int ny = node.y + dy[k];
						//좌표가 범위를 넘어갈때의 예외처리
						if(nx < 0 || nx >= cnt || ny < 0 || ny >= cnt) {
							continue;
						}
						//같은 색이고 방문을 하지 않았다면 큐와 방문기록 추가
						if(arr1[nx][ny] == arr1[node.x][node.y] && checker1[nx][ny] == false) {
							q.offer(new Node(nx, ny));
							checker1[nx][ny] = true;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < cnt; j++) {
				if(checker2[i][j] == true) {
					continue;
				}
				
				num2++;
				q.add(new Node(i, j));
				checker2[i][j] = true;
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					for(int k = 0; k < 4; k++) {
						int nx = node.x + dx[k];
						int ny = node.y + dy[k];
						//좌표가 범위를 넘어갈때의 예외처리
						if(nx < 0 || nx >= cnt || ny < 0 || ny >= cnt) {
							continue;
						}
						//같은 색이고 방문을 하지 않았다면 큐와 방문기록 추가
						if(arr2[nx][ny] == arr2[node.x][node.y] && checker2[nx][ny] == false) {
							q.offer(new Node(nx, ny));
							checker2[nx][ny] = true;
						}
					}
				}
			}
		}
		
		System.out.println(num1 + " " + num2);
	}
}