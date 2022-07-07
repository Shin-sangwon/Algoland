import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int target = 2;
		while(n != 1) {
			if(n % target == 0) {
				n /= target;
				sb.append(target+"\n");
			}else {
				target += 1;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}