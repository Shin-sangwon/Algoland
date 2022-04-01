import java.io.*;
import java.util.*;

public class Main {
	
	
	static boolean check(int a) {
		boolean ans = true;
		if(a == 1) return false;
		for(int i = 2; i <= Math.sqrt(a); i++) {
			if(a % i == 0) {
				ans = false;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int min = 0;
		boolean tmp = false;
		for(int i = start; i <= end; i++){
			if(check(i)) {
				answer += i;
				
			}
			if(check(i) && tmp == false) {
				min = i;
				tmp = true;
			}
			
		}
		
		if(answer == 0) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
			System.out.println(min);
		}
		
	}
}