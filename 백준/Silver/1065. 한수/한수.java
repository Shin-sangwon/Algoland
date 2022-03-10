import java.util.*;


public class Main {
	
	public static boolean calc(int a) {
		boolean flag = false;
		if(a < 100) {
			flag = true;
		}else if(a == 1000) {
			flag = false;
		}else {
			int b = a;
			int arr[] = new int[3];
			for(int i = 0; i < 3; i++) {
				arr[i] = b % 10;
				b /= 10;
			}
			if((arr[0] - arr[1]) == (arr[1] - arr[2])) {
				flag = true;
			}
		}		
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int ans = 0;
		for(int i = 1; i <= cnt; i++) {
			if(calc(i)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}