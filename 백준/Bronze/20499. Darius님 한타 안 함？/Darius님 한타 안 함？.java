import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), "/");
		
		int k = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		
		bw.write(k+a < d || d == 0 ? "hasu" : "gosu");
		bw.flush();
		bw.close();
	}
}