import java.util.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		int arr[] = new int[100001];
		boolean checker[] = new boolean[100001];
		
		//arr[] 값의 -1, +1, *2로 이동가능
				
		int ans = 0;
		arr[start] = 1;
		checker[start] = true;
		q.add(start);
		while(checker[target] == false) {
			while(!q.isEmpty()) {
				int x = q.poll();
				if(x == target) {
					ans = arr[target];
					break;
				}
				
				if(x - 1 >= 0 && checker[x-1] == false) {
					checker[x-1] = true;
					arr[x-1] = arr[x]+1;
					q.add(x-1);
				}
				
				if(x + 1 <= 100000 && checker[x+1] == false) {
					checker[x+1] = true;
					arr[x+1] = arr[x]+1;
					q.add(x+1);
				}
				
				if(x * 2 <= 100000 && checker[x*2] == false) {
					checker[x*2] = true;
					arr[x * 2] = arr[x]+1;
					q.add(2*x);
				}
			}
		}
		
		System.out.println(start == target? 0 : ans-1);
					
	}

}