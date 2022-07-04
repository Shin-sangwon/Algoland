import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int input[][] = new int[n][n];
		int ans[][] = new int[n][n];
		int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int dy[] = {1, 0, -1, 1, -1, 1, 0, -1};
		
		//입력처리
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < n; j++) {
				if(tmp.charAt(j) == '.') {
					input[i][j] = 0;
				}
				else {
					input[i][j] = Character.getNumericValue(tmp.charAt(j));
					ans[i][j] = -1;
				}		
			}
		}
		// 좌표값을 넘어서면 다음으로, 아니라면 입력받은 수 주변에 더해주기
		// 지뢰값에 대해 처리를 해야함
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(input[i][j] != 0) {
					for(int k = 0; k < 8; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(nx < 0 || ny < 0 || nx >= n || ny >= n || ans[nx][ny] == -1) {
							continue;
						}
						ans[nx][ny] += input[i][j];
					}
				}
			}
		}
		// 10이 넘으면 M, 입력받은 수라면 *, 모두 아니라면 수 출력
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(ans[i][j] > 9) {
					bw.write("M");
					continue;
				}
				if(ans[i][j] == -1) {
					bw.write("*");
					continue;
				}
				
				bw.write(ans[i][j]+"");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}