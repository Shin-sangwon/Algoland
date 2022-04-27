import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String first = st.nextToken();
		String last = st.nextToken();
		
		
		while(cnt-- != 0) {
			String tmp = br.readLine();
			if(tmp.length() <= 1 || first.length() > tmp.length() || last.length() > tmp.length() || (first.length() + last.length()) > tmp.length()) {
				bw.write("NE" + '\n');
				continue;
			}			
			if(tmp.substring(0, first.length()).equals(first) && tmp.substring(tmp.length()-last.length(), tmp.length()).equals(last)) {
				bw.write("DA" + '\n');
			}else {
				bw.write("NE" + '\n');
			}
		}
		bw.flush();
		bw.close();
	}
}