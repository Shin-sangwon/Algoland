import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		String arr[] = new String[cnt];
		String ans = "";
		boolean flag = false;
		//97
		int alpha[] = new int[26];
		
		for(int i = 0; i < cnt; i++) {
			arr[i] = br.readLine();
			char tmp = arr[i].charAt(0);
			alpha[tmp - 97]++;
		}
		
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i] >= 5) {
				ans += (char)(i+97);
				flag = true;
			}
		}
		
		bw.write(flag? ans : "PREDAJA");
		bw.flush();
		bw.close();
		
	}
}