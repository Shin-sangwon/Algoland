import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int ans = 100000;
	static int n, m;
	static char arr[][], w_board[][], b_board[][];
	
	static void checker(int x, int y) {
		
		int w_checker = 0, b_checker = 0;
		
		for(int i = x; i < 8+x; i++) {
			for(int j = y; j < 8+y; j++) {
				if(arr[i][j] != w_board[i-x][j-y]) w_checker++;
				if(arr[i][j] != b_board[i-x][j-y]) b_checker++;
			}
		}
		
		ans = Math.min(ans, Math.min(w_checker, b_checker));
		
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		char w_arr[] = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
		char b_arr[] = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
		
		arr = new char[n][m];
		w_board = new char[8][8];
		b_board = new char[8][8];
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i % 2 == 0) w_board[i][j] = w_arr[j];
				else w_board[i][j] = b_arr[j];
				
				if(w_board[i][j] == 'W') b_board[i][j] = 'B';
				else b_board[i][j] = 'W';
			}
		}
		
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0; i < n - 7; i++) {
			for(int j = 0; j < m - 7; j++) {
				checker(i, j);
			}
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		
	}
}