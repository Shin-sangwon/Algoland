import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	static boolean prime[];
	
	static int checker(int n) {
		
		if(n == 1) return 2;
		
		Loop1:
		for(int i = n; ; i++) {
			if(prime[i]) continue;
			String tmp = String.valueOf(i);
			for(int j = 0; j < tmp.length()/2; j++) {
				if(tmp.charAt(j) != tmp.charAt(tmp.length()-j-1)) continue Loop1;
			}
			return i;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int n = Integer.parseInt(br.readLine());
		
		prime = new boolean[1003002];
		
		//에라토스테네스의 체, false가 prime
		for(int i = 2; i < prime.length; i++) {
			if(prime[i]) continue;
			for(int j = i * 2; j < prime.length; j+=i) {
				prime[j] = true;
			}
		}
		
		bw.write(checker(n)+"");
		bw.flush();
		bw.close();
		
	}
}