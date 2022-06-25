import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		StringBuilder reversesb;
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine(), " ");	
			while(st.hasMoreTokens()) {				
				sb = new StringBuilder();
				sb.append(st.nextToken()).reverse();
				sb.append(" ");
				bw.write(sb.toString());
			}			
			bw.newLine();
		}
		
		br.close();
		bw.close();
			
	}
}