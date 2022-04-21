import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		Long arr[] = new Long[101];
		
		arr[1] = 1L; arr[2] = 1L; arr[3] = 1L; arr[4] = 2L; arr[5] = 2L;
		
		for(int i = 6; i < 101; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt-- != 0) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}
	}
			
}