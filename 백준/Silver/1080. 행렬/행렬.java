import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static boolean arr[][], target[][];
	
	public static boolean isSame() {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] != target[i][j]) return false;
			}
		}
		
		
		return true;
	}
	
	public static void reverse(int x, int y) {
		
		for(int i = x; i <= x+2; i++) {
			for(int j = y; j <= y+2; j++) {
				arr[i][j] = !arr[i][j];
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new boolean[n][m];
		target = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(tmp[j] == '1') {
					
					arr[i][j] = true;
					continue;
				}
				
				arr[i][j] = false;
			}
		}
		
		for(int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(tmp[j] == '1') {
					target[i][j] = true;
					continue;
				}  
				
				target[i][j] = false;
				
			}
		}
		
		int answer = 0;
		
		for(int i = 0; i <= n-3; i++) {
			for(int j = 0; j <= m-3; j++) {	
				if(arr[i][j] != target[i][j]) {
					answer++;
					reverse(i, j);
				}
			}
		}
		
		bw.write(isSame()? answer + "" : "-1");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
