import java.util.*;


public class Main {
	
	public static int plus(int a) {
		int sum = a;
		
		while(a != 0) {
			sum += a % 10;
			a /= 10;
		}
		
		return sum;
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int ans = 0;
		int tmp = 1;
			while(tmp < cnt) {
				if(plus(tmp) == cnt) {
					ans = tmp;
					break;
				}else {
					tmp++;
				}
			}
		System.out.println(ans);
		
	}
}
