import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	static long primeNum(long n) {
		
		if(n == 0 || n == 1 || n == 2) return 2;
		
		Loop1:
		for(long i = n; true; i++) {
			if(i % 2 == 0) continue Loop1;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) continue Loop1;
			}
			return i;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		long n = Long.parseLong(br.readLine());
		
		while(n-->0) {
			bw.write(primeNum(Long.parseLong(br.readLine()))+"\n");
		}
		
		bw.flush();
		bw.close();
		
		
		
	}
}