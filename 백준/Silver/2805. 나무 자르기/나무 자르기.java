import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long start = 1L;
		long end = 2000000000L;
		long result = 0L;
			
		while(start <= end) {
			long rest = 0L;
			long mid = (end+start) / 2;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] - mid >= 0) {
					rest += arr[i] - mid;
				}
			}
			if(rest < m) {
				end = mid - 1;
			}else if(rest >= m){
				result = mid;
				start = mid + 1;
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}