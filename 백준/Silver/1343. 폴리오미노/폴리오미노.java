import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp = br.readLine();
		
		while(tmp.contains("XXXX")) {
			tmp = tmp.replace("XXXX", "AAAA");
		}
		
		while(tmp.contains("XX")) {
			tmp = tmp.replace("XX", "BB");
		}
		
		bw.write(!tmp.contains("X")? tmp : -1+"");
		bw.flush();
		bw.close();
		
		
		
		
		

		
	}
}