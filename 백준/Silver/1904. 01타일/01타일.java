import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[1000001];
		
		arr[1] = 1; arr[2] = 2; arr[3] = 3;
		
		for(int i = 4; i <= n; i++) {
			arr[i] = (arr[i-2] + arr[i-1]) % 15746;
		}
		
		bw.write(arr[n]+"");
		bw.flush();
		bw.close();
		br.close();
			
	}
}