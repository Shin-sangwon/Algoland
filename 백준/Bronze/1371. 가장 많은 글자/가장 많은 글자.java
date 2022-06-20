import java.util.*;
import java.io.*;

public class Main {
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String tmp;
		
		int arr[] = new int[26];
		int max = Integer.MIN_VALUE;
		
		while((tmp = br.readLine()) != null) {
			for(int i = 0; i < tmp.length(); i++) {
				if(tmp.charAt(i) != ' ') {
					arr[tmp.charAt(i) - 97]++;
				}
			}
		}
		br.close();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == max) {
				bw.write((char)(i + 97)+"");
			}
		}
		
		bw.flush();
		bw.close();
		
	}
}