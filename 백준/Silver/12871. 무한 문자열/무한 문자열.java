import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		for(int i = 0; i < 101; i++) {
			sb1.append(str1);
			sb2.append(str2);
		}
		
		bw.write(sb1.substring(0,101).equals(sb2.substring(0,101))? "1" : "0");
		bw.flush();
		bw.close();
		br.close();
		
	}
}