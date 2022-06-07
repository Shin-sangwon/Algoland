import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		ArrayList<String> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		while(n-- != 0) {
			al.add(br.readLine());
		}
		
		
		while(m-- != 0) {
			if(al.contains(br.readLine())) {
				ans++;
			}
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
}