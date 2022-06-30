import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int GCD(int a, int b) {
		
		if(b == 0) return a;	
		return GCD(b, a%b);
	}
	
	static int LCM(int a, int b) {
		
		return (a * b / GCD(a,b));
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			sb.append(LCM(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
				
		
	}
}