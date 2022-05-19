import java.util.*;
import java.io.*;

public class Main {
	
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt[] = new int[arr.length-1];
		Arrays.sort(arr);
		
		for(int i = 0; i < cnt.length; i++) {
			cnt[i] = arr[i+1] - arr[i];
		}
		
		int tmp = cnt[0];
		
		for(int i = 1; i < cnt.length; i++) {
			tmp = gcd(tmp, cnt[i]);
		}
		
		System.out.println(tmp);
		
	}
}