import java.util.*;
import java.io.*;

public class Main {
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp = br.readLine();
		
		for(int i = tmp.length()-1; i >= 0; i--) {
			bw.write(tmp.charAt(i)+"");
		}
		
		bw.flush();
		bw.close();
	}
}