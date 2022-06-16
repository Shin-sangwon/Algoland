import java.util.*;
import java.io.*;

public class Main {
	

		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int q = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int ans1 = 0;
		int ans2 = 0;
		
		Integer arr1[] = new Integer[n];
		Integer arr2[] = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			ans2 += Math.max(arr1[i], arr2[i]);
		}
		
		Arrays.sort(arr2);
		
		for(int i = 0; i < n; i++) {
			ans1 += Math.max(arr1[i], arr2[i]);
		}
		
		bw.write(q == 1? ans1+"" : ans2+"");
		bw.flush();
		bw.close();
		
	}

}