import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static boolean isPrime(int n) {
		
		if(n < 2) {
			return false;
		}
		
		int sqrt = (int) Math.sqrt(n);
		for(int i = 2; i <= sqrt; i++) {
			
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int start = (int) Math.pow(10, n-1);
		int target = (int) Math.pow(10, n);

		Loop1:
		for(int i = start; i < target; i++) {
			
			int index = start;
			
			while(index != 0) {
				
				if(isPrime(i / index)) {
					index /= 10;
					continue;
				}

				continue Loop1;
			}
			
			sb.append(i).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
