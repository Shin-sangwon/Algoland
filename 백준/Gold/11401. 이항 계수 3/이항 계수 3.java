import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final long MOD = 1_000_000_007;
	static int n, r;
	
	//팩토리얼 구해주기
	private static long fact(int x) {
		
		long idx = 1L;
		
		for(int i = 1; i <= x; i++) {
			idx *= i;
			idx %= MOD;
		}
		
		return idx % MOD;
	}
	
	//분할정복을 이용한 거듭제곱
	private static long pow(long base, long exp) {
		
		if(exp == 1) {
			return base % MOD;
		}
		
		long half = pow(base, exp / 2);
		
		if(exp % 2 == 1) return (half * half % MOD) * base % MOD;
		
		return half * half % MOD;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		// n! / (k! * (n-k)!) % mod
		
		long nn = fact(n);
		long rr = fact(r) * fact(n - r) % MOD;
		
		long answer = nn * pow(rr, MOD - 2) % MOD;
		
		System.out.println(answer);
	}

}
