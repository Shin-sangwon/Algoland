import java.io.*;
import java.util.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int cnt = Integer.parseInt(br.readLine());
		int arr[] = new int[2000001];
		boolean check[] = new boolean[2000001];
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for(int i = 0; i < cnt; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
			check[tmp] = true;
		}
		
		int target = Integer.parseInt(br.readLine());
		for(int i = 0; i < cnt; i++) {
			if((target-arr[i]) > 0 && check[target - arr[i]] == true) ans++;
		}
		
		System.out.println(ans/2);
		
	}

}