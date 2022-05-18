import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ans = Integer.MAX_VALUE;
		
		int arr1[] = new int[3];
		int arr2[] = new int[2];
		
		arr1[0] = Integer.parseInt(br.readLine());
		arr1[1] = Integer.parseInt(br.readLine());
		arr1[2] = Integer.parseInt(br.readLine());
		arr2[0] = Integer.parseInt(br.readLine()) - 50;
		arr2[1] = Integer.parseInt(br.readLine()) - 50;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				ans = Math.min(arr1[i] + arr2[j], ans);
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
}