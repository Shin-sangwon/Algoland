import java.io.*;
import java.util.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[9];
		
		int count = Integer.parseInt(br.readLine());		
		int flag = 1;
		
		while(count != 0) {
			if(count % 10 == 9) {
				arr[6]++;
			}else {
				arr[count%10]++;
			}
			count /= 10;
		}
		
		if(arr[6] % 2 == 0) {
			arr[6] /= 2;
		}else {
			arr[6] = arr[6] / 2 + 1;
		}
		Arrays.sort(arr);
		
		
		System.out.println(Math.max(flag, arr[8]));
		
		
	}

}