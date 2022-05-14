import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//65;		
		int cnt = Integer.parseInt(br.readLine());
		int ans = 0;
		HashSet<String> set = new HashSet<>();
		
		while(cnt-- != 0) {
			String tmp = br.readLine();
			if(tmp.equals("ENTER")) {
				ans += set.size();
				set.clear();
			}else {
				set.add(tmp);
			}					
		}
		ans += set.size();
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
