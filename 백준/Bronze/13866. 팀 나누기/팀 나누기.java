import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[4];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(Math.abs((arr[0]+arr[3]) - (arr[1] + arr[2]))+"");
		bw.flush();
		bw.close();
	}
}