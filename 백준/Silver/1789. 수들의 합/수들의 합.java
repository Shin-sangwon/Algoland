import java.util.*;
import java.math.*;


public class Main {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long cnt = 1;
		long target = 0;
		int ans = 0;
		while(true) {
			target += cnt;
			if(target > n) break;
			cnt++;
		}
		System.out.println(cnt - 1);
		
		
	}
}