import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1. combination nCm >> n! / (n-m)!m!
// 2. (n!에대한 2, 5) - ((n - m)! 에 대한 2, 5 + m!에 대한 2,5));
// 3. 내가 전에 풀었던 완전탐색은 20억번을 반복하므로 > 시간초과
// 4. 60! 이라 가정했을때, 60! 중에서 5를 배수로 가지고 있는 수는 60/5
// 5. 이를 반복하여 2와 5의 갯수를 뽑아낸다
public class Main {
	
	static long cntFive(long five) {
		int cnt = 0;
		
		while(five >= 5) {
			cnt += five / 5;
			five /= 5;
		}
		
		return cnt;
	}
	
	static long cntTwo(long two) {
		int cnt = 0;
		
		while(two >= 2) {
			cnt += two / 2;
			two /= 2;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long ans[] = new long[2];
		
		ans[0] = cntTwo(n) - cntTwo(n-m) - cntTwo(m);
		ans[1] = cntFive(n) - cntFive(n-m) - cntFive(m);
		
		bw.write(Math.min(ans[0], ans[1])+"");
		bw.flush();
		bw.close();
	}
}