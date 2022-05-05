import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt-- != 0) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n+1];
			Arrays.fill(arr, 1);
			int tmp = 2;
			int ans = 0;
			for(int i = 2; i <= n; i++) {
				for(int j = 1; j < arr.length; j++) {
					if(j % tmp == 0) arr[j] *= -1;
				}
				tmp++;
			}
			
			for(int i = 1; i < arr.length; i++) {
				if(arr[i] == 1) ans++;
			}
			
			bw.write(ans+""+'\n');
		}
		
		bw.flush();
		bw.close();
	}

}