import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int target = Integer.parseInt(br.readLine());
		
		int n = 0;
		
		int ans = 0;
		
		while(true) {
			n++;
			String tmp = Integer.toString(n);
			if(tmp.contains("666")) ans++;
			if(ans == target) break;
		}
		
		bw.write(n+"");
		bw.flush();
		bw.close();
				
	}
}