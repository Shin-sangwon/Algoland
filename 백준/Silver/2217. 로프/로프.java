import java.util.*;


public class Main {
	
	

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		Integer arr[] = new Integer[cnt];
		for(int i = 0; i < cnt; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int max = arr[0];
		int ans = 0;
		
		if(cnt == 1) {
			ans = arr[0];
		}else {
			for(int i = 1; i < cnt; i++) {
				int tmp = arr[i] * (i+1);
				if(max <= tmp) {
					max = tmp;
					if(i == cnt-1) ans = max;
				}else {
					ans = max;
					
				}
			}
		}
		System.out.println(ans);	
	}
}
