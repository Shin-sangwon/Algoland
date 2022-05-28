import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-- != 0) {
			int k = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;
			String ans = "";
			while(k-- != 0) {
				st = new StringTokenizer(br.readLine());
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp > max) {
					max = tmp;
					ans = st.nextToken();
				}
			}
			bw.write(ans+'\n');
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}