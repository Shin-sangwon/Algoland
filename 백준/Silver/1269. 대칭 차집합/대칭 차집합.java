import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		int common = 0;
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		while(n-- != 0) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		while(m-- != 0) {
			int tmp = Integer.parseInt(st.nextToken());
			if(set.contains(tmp)) common++;
			else set.add(tmp);
		}
		
		bw.write(set.size() - common + "");
		bw.flush();
		bw.close();
		
	}
}