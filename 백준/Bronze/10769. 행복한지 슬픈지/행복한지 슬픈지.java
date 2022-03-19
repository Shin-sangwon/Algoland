import java.io.*;
import java.util.*;

public class Main {
	
	

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int arr[] = new int[2];
		
		for(int i = 0; i < str.length()-3; i++) {
			if(str.substring(i, i+3).equals(":-)")) {
				arr[0]++;
			}else if(str.substring(i, i+3).equals(":-(")) {
				arr[1]++;
			}
		}
		
		if(arr[0] > arr[1]) {
			System.out.println("happy");
		}else if(arr[0] < arr[1]) {
			System.out.println("sad");
		}else if(arr[0] == 0 && arr[1] == 0){
			System.out.println("none");
		}else if(arr[0] == arr[1]) {
			System.out.println("unsure");
		}
		
	}
}