import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		
		char arr[] = br.readLine().toCharArray();
		
		while(n-- != 1) {
			String tmp = br.readLine();
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != tmp.charAt(i)) arr[i] = '?'; 
			}
		}
		
		for(char x : arr) bw.write(x);
		bw.flush();
		bw.close();
		br.close();
	}
}