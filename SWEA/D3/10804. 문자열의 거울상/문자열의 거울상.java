import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


class Solution{
	
	final static char b = 'd';
	final static char d = 'b';
	final static char p = 'q';
	final static char q = 'p';
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
	
		int testCase = Integer.parseInt(br.readLine());
		int idx = 1;
		
		while(testCase-- > 0) {
			
			sb.append(String.format("#%d ", idx++));
			String tmp = br.readLine();
			StringBuilder tmpSb = new StringBuilder();
			for(int i = 0; i < tmp.length(); i++) {
				if(tmp.charAt(i) == 'b') {
					tmpSb.append(b);
					continue;
				}
				if(tmp.charAt(i) == 'd') {
					tmpSb.append(d);
					continue;
				}
				if(tmp.charAt(i) == 'p') {
					tmpSb.append(p);
					continue;
				}
				if(tmp.charAt(i) == 'q') {
					tmpSb.append(q);
					continue;
				}
				
			}
			
			sb.append(tmpSb.reverse().toString()+"\n");
			
		
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
