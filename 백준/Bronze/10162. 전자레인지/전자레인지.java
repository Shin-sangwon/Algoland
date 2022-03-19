import java.io.*;
import java.util.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = {300, 60, 10};
		int ans[] = new int[3];
		int cnt = Integer.parseInt(br.readLine());
		
		if(cnt % 10 != 0) {
			System.out.println(-1);
			cnt = 0;
		}else {
			while(cnt != 0) {
				if(cnt >= 300) {
					cnt -= 300;
					ans[0]++;
				}else if(cnt < 300 && cnt >= 60) {
					cnt -= 60;
					ans[1]++;
				}else {
					cnt -= 10;
					ans[2]++;
				}
			}
			for(int x : ans) System.out.print(x + " ");
		}
		
	
		br.close();
		
		
		
	}
}