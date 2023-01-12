import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[n][m];
		TreeSet<String> set = new TreeSet<>();
		//입력
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		//가로
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				// #을 만났을 떄
				if(arr[i][j] == '#') {
					// 2글자 이상이 되지 않으면 초기화하고 다음행으로
					if(sb.length() <= 1) {
						sb.setLength(0);
						continue;
					}
					//2글자 이상이라면 추가하기
					set.add(sb.toString());
					sb.setLength(0);
					continue;
					
				}
				
				sb.append(arr[i][j]);
				//마지막 문자일때
				if(j == m-1) {
					//1글자라면
					if(sb.length() <= 1) {
						sb.setLength(0);
						continue;
					}
					
					//아니라면
					set.add(sb.toString());
					sb.setLength(0);
				}
				
				
				
			}
		}
		
		//세로
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				
				// #을 만났을 떄
				if(arr[j][i] == '#') {
					// 2글자 이상이 되지 않으면 초기화하고 다음열로
					if(sb.length() <= 1) {
						sb.setLength(0);
						continue;
					}
					//2글자 이상이라면 추가하기
					set.add(sb.toString());
					sb.setLength(0);
					continue;
					
				}
				
				sb.append(arr[j][i]);
				
				if(j == n-1) {
					//1글자라면
					if(sb.length() <= 1) {
						sb.setLength(0);
						continue;
					}
					
					//아니라면
					set.add(sb.toString());
					sb.setLength(0);
				}
				
			}
		}
		
		bw.write(set.first().toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
