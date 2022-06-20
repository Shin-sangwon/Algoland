import java.util.*;
import java.io.*;

public class Main {
	

		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//'a' = 97; 'z' = 122 'A' = 65 'Z' = 90
		
		String tmp = br.readLine();
		String ans = "";
		
		for(int i = 0; i < tmp.length(); i++) {
			if(tmp.charAt(i) <= 90) {	
				ans += (char)(tmp.charAt(i) + 32);
				continue;
			}
			
			ans += (char)(tmp.charAt(i) - 32);
		}
		
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		
	}

}