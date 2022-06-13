import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals("END")) break;
			
			String print = "";
			
			for(int i = tmp.length()-1; i >= 0; i--) {
				print += tmp.charAt(i);
			}
			
			bw.write(print+'\n');
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}