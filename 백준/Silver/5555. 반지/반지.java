import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String target = br.readLine();
		
		
		int cnt = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(cnt-- != 0) {
			String tmp = br.readLine();
			String standard = tmp + tmp;
			if(standard.contains(target)) ans++;
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
}