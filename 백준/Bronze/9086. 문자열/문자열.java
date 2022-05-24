import java.util.*;
import java.io.*;

public class Main {
	
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
					
		int n = Integer.parseInt(br.readLine());
		
		while(n--!=0) {
			String tmp = br.readLine();
			char a = tmp.charAt(0);
			char b = tmp.charAt(tmp.length()-1);
			bw.write(a+""+b+'\n');
		}
		
		
		bw.flush();
		bw.close();
		
	}
}