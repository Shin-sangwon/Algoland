import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		br.close();
		
		int arr[] = new int[k];
		
		for(int i = 1; i <= k; i++) {
			sb = new StringBuilder().append(i*n).reverse();
			arr[i-1] = Integer.parseInt(sb.toString());		
		}
		
		Arrays.sort(arr);
		bw.write(arr[k-1]+"");
		bw.flush();
		bw.close();
	}
}