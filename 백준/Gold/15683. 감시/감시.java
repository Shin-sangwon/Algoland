import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 중복순열로 카메라 별 방향 뽑아내기
 * 1번 카메라 --> 상 하 좌 우 일자로 쭈~~욱  4
 * 2번 카메라 --> 상하 좌우와 같이 반대 방향 감시 가능 2 --> 상하 좌우 이렇게 계산해버린다면 ? 4로 가능
 * 3번 카메라 --> 직각 방향만 가능 (상우 우하 하좌 좌상) 4
 * 4번 카메라 --> 세방향 (좌상우 상우하 우하좌 하좌상 ) 4
 * 5번 카메라 --> 전방향 1
 * 6 --> 벽 --> 1의 개수 * 4 + 2의 개수 * 2 + 3의 개수 * 4 + 4의 개수 * 4 + 5의 개수 * 1
 *  --> 2번을 4가지 경우로 분류한다면, 1 2 3 4 번 카메라의 수에 대해서 4까지 중복순열을 만들면 된다.
 * 
 * CCTV가 벽은 탐색할 수 없음
 */
public class Main {
	
	static int n,m, map[][], copyMap[][];
	static ArrayList<Node> cameraList;
	static int[] direction;
	static int answer;
	
	static class Node{
		int num;
		int x;
		int y;
		public Node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[][] copyMap() {
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = map[i][j];
			}
		}
		
		return arr;
	}
	
	private static void perm(int cnt) {
		
		if(cnt == cameraList.size()) {
			copyMap = copyMap();
			search();
			answer = Math.min(answer, calc());
			return;
		}
		
		//4방향을 뽑아낼거임
		for(int i = 1; i <= 4; i++) {
			direction[cnt] = i;
			perm(cnt + 1);
		}
		
	}
	
	private static int calc() {
		int tmp = 0;
		for(int[] x : copyMap) {
			for(int y : x) {
				if(y == 0) tmp++;
			}
		}
		
		return tmp;
	}
	
	private static void search() {
		
		for(int i = 0; i < cameraList.size(); i++) {
			
			Node node = cameraList.get(i);
			int dir = direction[i];
			
			if(node.num == 1) {
				copyMap = mapping(node, dir);
				continue;
			}
			
			if(node.num == 2) {
				if(dir == 1 || dir == 3) {
					copyMap = mapping(node, 1);
					copyMap = mapping(node, 2);
					continue;
				}
					copyMap = mapping(node, 3);
					copyMap = mapping(node, 4);
					continue;
			}
			
			if(node.num == 3) {
				// 상우 우하 하좌 좌상
				if(dir == 1) {
					copyMap = mapping(node, 1);
					copyMap = mapping(node, 4);
					continue;
				}
				
				if(dir == 2) {
					copyMap = mapping(node, 4);
					copyMap = mapping(node, 2);
					continue;
				}
				
				if(dir == 3) {
					copyMap = mapping(node, 2);
					copyMap = mapping(node, 3);
					continue;
				}
				
				copyMap = mapping(node, 3);
				copyMap = mapping(node, 1);
				continue;
			}
			//좌상우 상우하 우하좌 하좌상
			if(node.num == 4) {
				
				if(dir == 1) {
					copyMap = mapping(node, 3);
					copyMap = mapping(node, 1);
					copyMap = mapping(node, 4);
					continue;
				}
				
				if(dir == 2) {
					copyMap = mapping(node, 1);
					copyMap = mapping(node, 4);
					copyMap = mapping(node, 2);
					continue;
				}
				
				if(dir == 3) {
					copyMap = mapping(node, 4);
					copyMap = mapping(node, 2);
					copyMap = mapping(node, 3);
					continue;
				}
				
				copyMap = mapping(node, 2);
				copyMap = mapping(node, 3);
				copyMap = mapping(node, 1);
				continue;

			}
			
			copyMap = mapping(node, 1);
			copyMap = mapping(node, 2);
			copyMap = mapping(node, 3);
			copyMap = mapping(node, 4);
			
		}
		
	}
	
	private static int[][] mapping(Node node, int dir) {
		
		int x = node.x;
		int y = node.y;
		
			//1번카메라 상 하 좌 우 순서로
			if(dir == 1) {
				while(x != 0) {
					x--;
					if(x < 0 || copyMap[x][y] == 6) break;
					copyMap[x][y] = -1;
				}
				
			}
			
			if(dir == 2) {
				while(x != n) {
					x++;
					if(x >= n || copyMap[x][y] == 6) break;
					copyMap[x][y] = -1;
				}
				
			}
			
			if(dir == 3) {
				while(y != 0) {
					y--;
					if(y < 0 || copyMap[x][y] == 6) break;
					copyMap[x][y] = -1;
				}
				
			}
			
			if(dir == 4) {
				while(y != m) {
					y++;
					if(y >= m || copyMap[x][y] == 6) break;
					copyMap[x][y] = -1;
				}
			}

		return copyMap;
	}
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cameraList = new ArrayList<>();
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					cameraList.add(new Node(map[i][j], i, j));
				}
			}
		}
		
		direction = new int[cameraList.size()];
		answer = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(answer);
	}

}
