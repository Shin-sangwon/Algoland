import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {
	
	static StringBuilder sb;
	
	static void checker(int to, int from) {
		
		if(from > 10000001) from = 10000000;
		Loop1:
		for(int i = to; i <= from; i++) {
			String tmp = String.valueOf(i);
			for(int j = 0; j < tmp.length()/2; j++) {
				if(tmp.charAt(j) != tmp.charAt(tmp.length()-1-j)) continue Loop1;
			}
			BigInteger bi = new BigInteger(tmp);
			if(bi.isProbablePrime(10)) sb.append(bi+"\n");
		}
	}

	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		br.close();
		int to = Integer.parseInt(st.nextToken());
		int from = Integer.parseInt(st.nextToken());
		
		checker(to, from);
		sb.append(-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}
}