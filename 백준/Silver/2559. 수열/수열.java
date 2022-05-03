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
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer, sum = 0;
		
		if(k > n){
			answer = 0;
			for(int x : arr) answer += x;
		}else {
			for(int i = 0; i < k; i++) sum += arr[i];
			answer = sum;
			for(int i = k; i < n; i++) {
				sum +=( arr[i] - arr[i-k]);
				answer = Math.max(answer,sum);
			}
		}
			
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}

}