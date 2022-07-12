import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	static int isPrime(int n, int k) {
		int cnt = 0;
		//에라토스테네스의 체
		boolean arr[] = new boolean[n+1];
		
		for(int i = 2; i <= n; i++) {
			if(arr[i]) continue; // 이미 지웠다면 다음분기
			cnt++; // count 증가
			if(cnt == k) return i; // k값이랑 값으면 지금 지운 수 리턴
			for(int j = i * 2; j <= n; j += i) {
				if(arr[j]) continue; // 이미 지운값이면 다음 분기로
				cnt++;
				arr[j] = true; 
				if(cnt == k) return j; // k 값이랑 같으면 지금 지운 수 리
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bw.write(isPrime(n,k)+"");
		bw.flush();
		bw.close();
		
		
	}
}