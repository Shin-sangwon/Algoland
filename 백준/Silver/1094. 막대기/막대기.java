import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int target = Integer.parseInt(br.readLine());
		
		String ans = Integer.toBinaryString(target);
		
		int cnt = 0;
		
		for(int i = 0; i < ans.length(); i++) {
			if(ans.charAt(i) == '1') cnt++;
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
}