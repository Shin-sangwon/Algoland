import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
			
		int arr[] = new int[1000001];
		for(int i = 2; i <= 1000000; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i <= 1000000; i++) {
			if(arr[i] == 0) continue;
			
			for(int j = 2*i; j <= 1000000; j+=i) {
				arr[j] = 0;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = n; i <= m; i++) {
			if(arr[i] != 0) sb.append(i+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}