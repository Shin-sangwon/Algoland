import java.util.*;
import java.io.*;

public class Main {
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	
	static int lcm(int a, int b) {
		return(a * b / gcd(a, b));
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		bw.write(gcd(a,b)+""+'\n');
		bw.write(lcm(a,b)+"");
		bw.flush();
		bw.close();
	}
}