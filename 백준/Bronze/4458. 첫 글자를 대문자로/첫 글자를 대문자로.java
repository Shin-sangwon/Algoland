import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringBuilder sb = new StringBuilder();
		// 'a' 97 'z' 122 'A' 65 'Z' 90 => 32
		int n =	Integer.parseInt(br.readLine());
		
		
		while(n-->0) {
			String tmp = br.readLine();
			
			if(tmp.charAt(0) >= 97 && tmp.charAt(0) <= 122) {
				sb.append((char)(tmp.charAt(0) - 32)).append(tmp.substring(1, tmp.length())).append("\n");
				continue;
			}
			
			sb.append(tmp).append("\n");
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}