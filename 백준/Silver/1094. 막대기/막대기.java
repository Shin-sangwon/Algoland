import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int target = Integer.parseInt(br.readLine());
		
		int start = 64;
		int cnt = 0;
		
		while(target > 0) {
			if(start > target) {
				start /= 2;
			}else {
				target -= start;
				cnt++;
			}
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
}