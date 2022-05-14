import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int ans = 0;
		int chicken = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int coke = Integer.parseInt(st.nextToken());
		int beer = Integer.parseInt(st.nextToken());
		
		ans += coke / 2;
		while(beer-- != 0) {
			ans += 1;
		}
		
		bw.write(ans < chicken? ans+"" : chicken+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
}