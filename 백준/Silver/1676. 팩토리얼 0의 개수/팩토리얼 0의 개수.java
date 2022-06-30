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
		
		int n = Integer.parseInt(br.readLine());
		int ans[] = new int[2];
		
		for(int i = 2; i <= n; i++) {
			int tmp = i;
			while(tmp % 2 == 0 || tmp % 5 == 0) {
				if(tmp % 2 == 0) {
					ans[0]++;
					tmp /= 2;
				}
				
				if(tmp % 5 == 0) {
					ans[1]++;
					tmp /= 5;
				}
			}
		}
		
		bw.write(Math.min(ans[0], ans[1])+"");
		bw.flush();
		bw.close();
		br.close();
	}
}