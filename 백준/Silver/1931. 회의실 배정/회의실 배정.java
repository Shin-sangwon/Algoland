import java.util.*;


public class Main {
	
	static int a = 5;

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int arr[][] = new int[cnt][2];
		for(int i = 0; i < cnt; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			arr[i][1] = a; arr[i][0] = b;
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		int ans = 0; int target = arr[0][1];
		
		for(int i = 0; i < cnt; i++) {
			if(target <= arr[i][1]) {
				ans++;
				target = arr[i][0];
			}
		}
		System.out.println(ans);
	}

}