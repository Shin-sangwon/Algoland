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
		
		int arr[] = new int[123456 * 2 + 1];
		
		for(int i = 0; i <arr.length; i++) arr[i] = i;
		
		arr[1] = 0;
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] == 0) continue;
			for(int j = i * 2; j < arr.length; j += i) {
				arr[j] = 0;
			}
		}
		
		while(true) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) break;
			int cnt = 0;
			
			for(int i = tmp+1; i <= tmp * 2; i++) {
				if(arr[i] != 0) cnt++;
			}
			
			bw.write(cnt+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}