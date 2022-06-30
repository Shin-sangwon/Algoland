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
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		int arr[] = new int[1001];
		for(int i = 2; i <= 1000; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i <= 1000; i++) {
			if(arr[i] == 0) continue;
			
			for(int j = 2*i; j <= 1000; j+=i) {
				arr[j] = 0;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			if(arr[tmp] != 0) ans++;
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		
	}
}