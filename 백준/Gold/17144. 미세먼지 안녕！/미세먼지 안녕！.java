import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	//상 하 좌 우
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static int n, m, t, map[][], copyMap[][], spreadRange[][];
	static Queue<Integer> queue1, queue2;
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void spread() {
		spreadRange = new int[n][m];
		copyMap = new int[n][m];
		//spreadRange에 이 미세먼지가 몇 가지 방향에 영향을 끼칠 수 있는지 판단
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				
				if(map[i][j] > 0) {
					int tmp = 0;
					for(int k = 0; k < 4; k++) {
						
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
						if(map[nx][ny] == -1) continue;
						tmp++;
					}
					
					spreadRange[i][j] = tmp;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				
				if(spreadRange[i][j] == 0) continue;
				
				int index = map[i][j] / 5;
				
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[i][j] == -1) continue;
					
					copyMap[nx][ny] += index;
				}
				
				map[i][j] -= (index * spreadRange[i][j]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				
				if(map[i][j] == -1) continue;
				
				map[i][j] += copyMap[i][j];
			}
		}
	}
	
	
	private static void clean(int cleaner) {
		
        for(int i = cleaner - 1; i > 0 ; i--) {
            map[i][0] = map[i - 1][0];
        }
       
        for(int j = 0; j < m - 1; j++) {
            map[0][j] = map[0][j + 1];
        }
        
        for(int i = 0; i < cleaner; i++) {
            map[i][m - 1] = map[i + 1][m - 1];
        }
        for(int j = m - 1; j > 0; j--) {
            map[cleaner][j] = map[cleaner][j - 1];
            if(map[cleaner][j] == -1) {
                map[cleaner][j] = 0;
            }
        }

        
        for(int i = cleaner + 2; i < n - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        
        for(int j = 0; j < m - 1; j++) {
            map[n - 1][j] = map[n - 1][j + 1];
        }
        
        for(int i = n - 1; i > cleaner + 1; i--) {
            map[i][m - 1] = map[i - 1][m - 1];
        }
        for(int j = m - 1; j > 0; j--) {
            map[cleaner + 1][j] = map[cleaner + 1][j - 1];
            if(map[cleaner + 1][j] == -1) {
                map[cleaner + 1][j] = 0;
            }
        }
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		int cleaner = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && cleaner == Integer.MIN_VALUE) cleaner = i;
			}
		}
		
		while(t-->0) {
			spread();
			clean(cleaner);
		}
		
		int answer = 0;
		for(int[] x : map) {
			for(int y : x) {
				if(y <= 0) continue;
				answer += y;
			}
		}
		
		System.out.println(answer);
	}

}
