import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, answer, map[][];
	
	private static int findMax(int[][] map) {
		
		int cnt = 0;
		
		for(int[] x : map) {
			for(int y : x) {
				cnt = Math.max(y, cnt);
			}
		}
		
		return cnt;
	}
	
	private static int[][] moveUp(int[][] map) {
		
		int[][] cloneMap = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int j = 0; j < n; j++) {
				
				if(map[j][i] == 0) continue;
				
				queue.add(map[j][i]);
			}
			
			int idx = 0;
			boolean flag = true;
			while(!queue.isEmpty()) {
				
				if(idx == 0) {
					cloneMap[idx][i] = queue.poll();
					idx++;
					continue;
				}
				
				if(cloneMap[idx - 1][i] == queue.peek() && flag) {
					
					cloneMap[idx - 1][i] *= 2;
					queue.poll();
					flag = false;
					continue;
				}
				
				cloneMap[idx][i] = queue.poll();
				idx++;
				flag = true;
			}
		}
		
		answer = Math.max(answer, findMax(cloneMap));
		return cloneMap;
	}
	
	private static int[][] moveDown(int[][] map) {
		
		int[][] cloneMap = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int j = n-1; j >= 0; j--) {
				
				if(map[j][i] == 0) continue;
				
				queue.add(map[j][i]);
			}
			
			int idx = n-1;
			boolean flag = true;
			
			while(!queue.isEmpty()) {
				
				if(idx == n-1) {
					cloneMap[idx][i] = queue.poll();
					idx--;
					continue;
				}
				
				if(cloneMap[idx + 1][i] == queue.peek() && flag) {
					
					cloneMap[idx + 1][i] *= 2;
					queue.poll();
					flag = false;
					continue;
				}
				
				cloneMap[idx][i] = queue.poll();
				idx--;
				flag = true;
			}
		}
		
		answer = Math.max(answer, findMax(cloneMap));
		return cloneMap;
	}
	
	private static int[][] moveLeft(int[][] map) {
		
		int[][] cloneMap = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			Queue<Integer> queue = new LinkedList<>();
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) continue;
				queue.add(map[i][j]);
			}
			
			int idx = 0;
			boolean flag = true;
			while(!queue.isEmpty()) {
				
				if(idx == 0) {
					cloneMap[i][idx] = queue.poll();
					idx++;
					continue;
				}
				
				if(cloneMap[i][idx - 1] == queue.peek() && flag) {
					cloneMap[i][idx - 1] *= 2;
					queue.poll();
					flag = false;
					continue;
				}
				
				cloneMap[i][idx] = queue.poll();
				idx++;
				flag = true;
			}
		}
		
		answer = Math.max(answer, findMax(cloneMap));
		return cloneMap;
	}
	
	private static int[][] moveRight(int[][] map) {
		
		int[][] cloneMap = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int j = n - 1; j >= 0; j--) {
				if(map[i][j] == 0) continue;
				queue.add(map[i][j]);
			}
			
			int idx = n - 1;
			boolean flag = true;
			while(!queue.isEmpty()) {
				
				if(idx == n - 1) {
					cloneMap[i][idx] = queue.poll();
					idx--;
					continue;
				}
				
				if(cloneMap[i][idx + 1] == queue.peek() && flag) {
					cloneMap[i][idx + 1] *= 2;
					queue.poll();
					flag = false;
					continue;
				}
				
				cloneMap[i][idx] = queue.poll();
				idx--;
				flag = true;
			}
		}
		
		answer = Math.max(answer, findMax(cloneMap));
		return cloneMap;
	}
	
	private static int[][] copy(int[][] map) {
		
		int[][] copyMap = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		return copyMap;
	}
	
	private static void backTracking(int cnt, int[][] map, int[][] preMap) {
		
		if(cnt == 5) return;
		
		if(cnt != 0 && Arrays.deepEquals(map, preMap)) return;
		
		int[][] copyMap = copy(map);
		backTracking(cnt + 1, moveUp(copyMap), copyMap);
		copyMap = copy(map);
		backTracking(cnt + 1, moveDown(copyMap), copyMap);
		copyMap = copy(map);
		backTracking(cnt + 1, moveLeft(copyMap), copyMap);
		copyMap = copy(map);
		backTracking(cnt + 1, moveRight(copyMap), copyMap);
		
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
			}
		}
		
		answer = Integer.MIN_VALUE;
		
		backTracking(0, map, map);
		
		System.out.println(answer);
	}

}
