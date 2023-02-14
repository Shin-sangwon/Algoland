import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,r, min;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	private static void rotate(int now, int depth) {
	
		int mod = r % depth;
		
		for(int i = 0; i < mod; i++) {
			int save = arr[now][now];
			
			int direction = 0;
			
			int x = now;
			int y = now;
			
			while(direction < 4) {
				
				int nx = dx[direction] + x;
				int ny = dy[direction] + y;
				
				if(nx >= now && ny >= now && nx < n - now && ny < m - now) {
					
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
					continue;
				}
				
				direction++;
			}
			
			arr[now+1][now] = save;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Math.min(n,m) / 2;
		int newN = n;
		int newM = m;
		
		for(int i = 0; i < min; i++) {
			rotate(i, 2 * newN + 2* newM - 4);
			newN -= 2;
			newM -= 2;
		}
		
		for(int[] x : arr) {
			for(int y : x) {
				sb.append(y + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
