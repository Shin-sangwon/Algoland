import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		
		int n = Integer.parseInt(br.readLine());
		int ans = 1;
		while(n-->0) {
			StringBuilder sb = new StringBuilder();
			String[] arr = br.readLine().split("\\s+");
			for(int i = arr.length-1; i >= 0; i--) {
				sb.append(arr[i] + " ");
			}
			System.out.printf("Case #%d: " + sb, ans++);
			System.out.println();
		}
		
	}
}