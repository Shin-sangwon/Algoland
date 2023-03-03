import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 자기보다 작은 물고기만 먹을 수 있음
 * 자기와 크기가 같은 물고기가 있는 칸은 지나갈 수 있음
 * 자기보다 큰 물고기가 있으면 못지나감
 */
public class Main {
	
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	static int n, answer, map[][];
	static boolean[][] visited;
	static Shark shark;
	static class Shark {
		int x;
		int y;
		int size;
		int stack;
		int move;
		public Shark(int x, int y, int size, int stack, int move) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.stack = stack;
			this.move = move;
		}
		
	}
	
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int dist;
		
		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		
		//1. 상어로부터의 거리 오름차순 2. 같다면, 위에 있는 순 3. 같다면, 더 왼쪽에 있는 순
		@Override
		public int compareTo(Fish o) {
			
			return this.dist == o.dist? (this.x == o.x? this.y - o.y : this.x - o.x) : this.dist - o.dist;
		}
	
		
	}
	
	//먹을 수 있는 물고기가 있는가?
	private static boolean checkFish(Shark shark) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 0 && map[i][j] != 9 && map[i][j] < shark.size) return true;
			}
		}
		
		return false;
		
	}
	
	//bfs
	private static void goFishing() {
		
		Loop1:
		while(checkFish(shark)) {
			//bfs 기본 세팅
			Queue<Shark> queue = new LinkedList<>();
			PriorityQueue<Fish> fishes = new PriorityQueue<>();
			boolean[][] visited = new boolean[n][n];
			visited[shark.x][shark.y] = true;
			queue.add(shark);
			
			while(!queue.isEmpty()) {
				
				Shark shark = queue.poll();
				
				for(int k = 0; k < 4; k++) {
					int nx = dx[k] + shark.x;
					int ny = dy[k] + shark.y;
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					if(visited[nx][ny]) continue;
					if(map[nx][ny] > shark.size) continue;
					
					visited[nx][ny] = true;
					//물고기가 있는 칸이고, 먹을 수 있다면 fishes에 넣어주기
					if(map[nx][ny] != 0 && map[nx][ny] < shark.size) {
						
						queue.add(new Shark(nx, ny, shark.size, shark.stack, shark.move + 1));
						fishes.add(new Fish(nx, ny, shark.move + 1));
						continue;
					}
					
					queue.add(new Shark(nx, ny, shark.size, shark.stack, shark.move + 1));
					
				}
			}
			
			//pq의 맨 첫번째 물고기가 대상
			if(fishes.isEmpty()) break Loop1;
			Fish fish = fishes.poll();
			
			map[shark.x][shark.y] = 0;
			shark.x = fish.x;
			shark.y = fish.y;
			shark.stack += 1;
			if(shark.stack == shark.size) {
				shark.stack = 0;
				shark.size++;
			}
			map[fish.x][fish.y] = 9;
			
			answer += fish.dist;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0, 0);
				}
			}
		}
		
		goFishing();
		
		System.out.println(answer);
		
	}

}
