import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int a = 0;
		int b = 0;
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) a += Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) b += Integer.parseInt(st.nextToken());
		
		bw.write(a > b ? a+"" : b+"");
		bw.flush();
		bw.close();
		br.close();
	}
}