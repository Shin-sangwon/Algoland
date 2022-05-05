import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int cnt = Integer.parseInt(br.readLine());
		int scoreA = 100;
		int scoreB = 100;
		
		while(cnt-- != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a > b) {
				scoreB -= a;
			}else if(b > a) {
				scoreA -= b;
			}
		}
		bw.write(scoreA+""+'\n');
		bw.write(scoreB+""+'\n');
		bw.flush();
		bw.close();
	}

}