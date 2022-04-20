import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr[] = new int[10];
		arr[0] = 5; arr[1] = 3;  for(int i = 2; i < 10; i++) arr[i] = 4;
		boolean flag = true;
		
		
		while(flag) {
			int ans = 1;
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				flag = false;
				break;
			}else {
				while(tmp != 0) {
					int target = tmp % 10;
					ans += arr[target];
					tmp /= 10;
				}
			}
			System.out.println(ans);
		}
		
		
	}
}
