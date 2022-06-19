import java.util.*;
import java.io.*;

public class Main {
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> set = new TreeSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(n-- != 0) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int x : set) bw.write(x + " ");
		bw.flush();
		bw.close();
		
		
	}
}