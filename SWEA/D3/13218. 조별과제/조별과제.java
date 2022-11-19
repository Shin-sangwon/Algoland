import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Solution{
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		int idx = 1;
		
		while(testCase-- > 0) {
			
			int n = Integer.parseInt(br.readLine()) / 3;
			sb.append(String.format("#%d %d\n", idx++, n));
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
