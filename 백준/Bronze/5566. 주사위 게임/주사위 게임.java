import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0; 
		int ans = 0;
		
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Loop1:
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			ans += tmp; cnt++;
			if(ans >= n-1 || ans + arr[ans] >= n-1) break Loop1;			
			ans += arr[ans];
		}
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}

}