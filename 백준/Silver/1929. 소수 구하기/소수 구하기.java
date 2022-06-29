import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		boolean prime[] = new boolean[1000001];
		prime[0] = true; prime[1] = true;
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		for(int i = 2; i*i <= m; i++) {
			if(!prime[i]) {
				for(int j = i*i; j <= m; j+=i) prime[j] = true;
			}
		}
		
		for(int i = n; i <= m; i++) {
			if(!prime[i]) System.out.println(i);
		}
		
	}
}