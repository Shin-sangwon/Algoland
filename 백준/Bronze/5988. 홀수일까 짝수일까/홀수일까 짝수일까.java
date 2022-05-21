import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		
		
		while(n-- != 0) {
			String tmp = br.readLine();
			char a = tmp.charAt(tmp.length()-1);
			switch(a) {
			case '0': case '2': case '4': case '6' :case '8':
				bw.write("even" + '\n');
				break;
			default:
				bw.write("odd"+ '\n');
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
			
	}
}