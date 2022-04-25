import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		int arr[] = new int[101];
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] >= 1) {
				arr[i] -= 1;
			}
		}
		
		for(int x : arr) ans += x;
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
			
}