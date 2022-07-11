import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	
	static long fibo(int x) {
		long arr[] = new long[x+1];
		
		if(x == 1) return 1;
		else {
			arr[1] = 1L; arr[2] = 1L;
			for(int i = 3; i <= x; i++) {
				arr[i] = arr[i-2] + arr[i-1];
			}
		}
		
		return arr[x];
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		bw.write(fibo(Integer.parseInt(br.readLine()))+"");
		bw.flush();
		bw.close();
		
	}
}