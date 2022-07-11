import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/*
 * 2 * n 배열에 사자를 배치하기
 * 가로로도, 세로로도 붙어있으면 안됨
 * 한마리도 배치하지 않는 것도 경우의 수
 * 
 * 1 > 3, 2 > 7, 3 > 17, 4 > 41, 5 > 99
 * 음 . . . . . . . . . . . .  . . . .
 */

public class Main {
	
	static int dynamic(int n) {
		
		int dp[] = new int[n+1];
		
		if(n == 1) return 3;
		else {
			dp[1] = 3; dp[2] = 7;
			for(int i = 3; i <= n; i++) {
				dp[i] = (dp[i-2] + dp[i-1] * 2) % 9901;
			}
		}
		
		return dp[n] % 9901;
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(dynamic(n)+"");
		bw.flush();
		bw.close();
		
	}
}