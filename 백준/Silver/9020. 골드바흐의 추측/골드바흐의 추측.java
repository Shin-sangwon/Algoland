import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[10001];
		
		for(int i = 0; i < 10001; i++) arr[i] = i;
		
		for(int i = 2; i < 10001; i++) {
			if(arr[i] == 0) continue;
			for(int j = i * 2; j < 10001; j+=i) {
				arr[j] = 0;
			}
		}
		
		while(n-->0) {
			int tmp = Integer.parseInt(br.readLine());
			for(int i = tmp/2; i >= 2; i--) {
				if(arr[i] != 0 && arr[tmp-i] != 0) {
					sb.append(i + " " + (tmp-i) + "\n");
					break;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}