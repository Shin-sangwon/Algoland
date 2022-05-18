import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			int tmp = 0;
			int end = i + 1;
			
			while(end < n) {
				tmp = arr[i];
				tmp += arr[end++];
				if(tmp == target) {
					ans++;
					break;
				}
			}
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}