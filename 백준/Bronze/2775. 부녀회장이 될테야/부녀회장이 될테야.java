import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//a층의 b호에 살려면 a-1층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 함
// 0층의 i호에는 i명이 산다
// 0층부터 있고 각 층에는 1호부터 있다

public class Main {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		while(count-->0) {
			//k층 n호
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = i+1;		
			}
			while(k-->0) {
				for(int i = 1; i < n; i++) {
					arr[i] += arr[i-1];
				}
			}
			bw.write(arr[n-1]+"\n");
		}
		bw.flush();
		bw.close();
		
	}
}