import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[k];
	
		for(int i = 0; i < k; i++) {
			arr[i] = Long.parseLong(br.readLine());
			
		}
		long start = 1L;
		long end = 2147483647L;
		long ans = 0L;
		while(start <= end) {
			int cnt = 0;
			long mid = (start+end)/2;
			for(int i = 0; i < arr.length; i++) {
				long tmp = arr[i];
				while(tmp - mid >= 0) {
					tmp -= mid;
					cnt++;
				}
			}
			if(cnt < n) {
				end = mid - 1;
			}else if(cnt >= n) {
				ans = mid;
				start = mid + 1;
			}			
		}
		bw.write(ans+"");	
		bw.flush();
		bw.close();
	}
}