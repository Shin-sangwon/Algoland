import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String ans = "";
		//A = 65 Z = 90 a = 97 z = 122	
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				char tmp = (char)(str.charAt(i) + 13);
				if(tmp > 'z') {
					tmp -= 26;
				}
				ans += tmp;
			}else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				char tmp = (char)(str.charAt(i) + 13);
				if(tmp > 'Z') {
					tmp -= 26;
				}
				ans += tmp;
			}else {
				ans += str.charAt(i);
			}			
		}
		bw.write(ans);
		bw.flush();
		bw.close();
	}
}