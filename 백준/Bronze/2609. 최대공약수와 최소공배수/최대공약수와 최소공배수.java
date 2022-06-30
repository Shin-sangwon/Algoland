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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		bw.write(GCD(n, m)+"\n"+LCM(n, m)+"");
		bw.flush();
		bw.close();
		
	}
}