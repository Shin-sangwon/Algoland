import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
					
		String str;
		
		while((str = br.readLine()) != null) {
			
			int arr[] = new int[4];
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') arr[0]++;
				if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') arr[1]++;
				if(str.charAt(i) >= '0' && str.charAt(i) <= '9' ) arr[2]++;
				if(str.charAt(i) == ' ') arr[3]++;
			}
			
			for(int x : arr) bw.write(x + " ");
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
				
	}
}