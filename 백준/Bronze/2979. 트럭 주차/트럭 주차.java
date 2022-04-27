import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int fee = 0;
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[101];		
		int cnt = 3;
		
		while(cnt-- != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			for(int i = first; i < last; i++) {
				arr[i]++;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) fee += a;
			if(arr[i] == 2) fee += b * 2;
			if(arr[i] == 3) fee += c * 3;
		}
		
		System.out.println(fee);
	}
}