import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long cnt = Integer.parseInt(br.readLine());
		long arr[] = new long[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		
		long ans = 0L;
		
		for(int i = 0; i < cnt; i++) {
			arr[i] -= main;
			ans++;
			if(arr[i] > 0) {
				if(arr[i] % sub == 0) {
					ans += arr[i] / sub;
				}else {
					ans += (arr[i] / sub) + 1;
				}
			}
		}
		System.out.println(ans);
		
	}
}