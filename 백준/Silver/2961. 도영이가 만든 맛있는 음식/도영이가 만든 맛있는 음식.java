import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static int[] sourArr;
	static int[] bitterArr;
	static int answer, n;
	
	/*
	 * 재료 N개, 신맛 S , 쓴맛 B
	 * 신맛 -> 곱, 쓴맛 -> 합
	 * 신맛과 쓴맛의 차이를 작게
	 * 재료는 적어도 하나 사용해야 함
	 */
	
	private static boolean checker(boolean[] arr) {
		
		for(boolean x : arr) {
			if(x) return false;
		}
		
		return true;
	}
	
	private static void calc(int cnt) {
		
		if(n == 1) {
			answer = Math.abs(sourArr[0] - bitterArr[0]);
			return;
		}
		
		if(cnt == n) {
			
			if(checker(visited)) return;
			
			int sour = 1;
			int bitter = 0;
			
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					sour *= sourArr[i];
					bitter += bitterArr[i];
				}
			}
			
			answer = Math.min(answer, Math.abs(sour - bitter));
			
			return;
		}
		
		visited[cnt] = true;
		calc(cnt + 1);
		visited[cnt] = false;
		calc(cnt + 1);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		sourArr = new int[n];
		bitterArr = new int[n];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sourArr[i] = Integer.parseInt(st.nextToken());
			bitterArr[i] = Integer.parseInt(st.nextToken());
		}
		
		calc(0);
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
