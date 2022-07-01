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
		int arr[] = new int[1000001];
		
		for(int i = 0; i < 1000000; i++) arr[i] = i;
		
		for(int i = 2; i < 1000000; i++) {
			if(arr[i] == 0) continue;
			for(int j = i * 2; j <= 1000000; j+=i ) {
				arr[j] = 0;
			}
		}
			
		while(true) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp == 0) break;
			
			
			for(int i = 3; i < arr.length; i++) {
				if(i > tmp) {
					sb.append("Goldbach's conjecture is wrong.\n");
					break;
				}
				
				if(arr[i] != 0 && arr[tmp-i] != 0) {
					sb.append(tmp + " = " + i + " + " + (tmp-i) + "\n");
					break;
				}
				
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}