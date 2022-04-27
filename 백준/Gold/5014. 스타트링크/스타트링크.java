import java.util.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int now = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		
		int ans = 0;
		arr[now] = 1;
		visited[now] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
			
			while(!q.isEmpty()) {
				int x = q.poll();
				if(x == target) {
					ans = arr[target];
					break;
				}
				
				if(x + up <= n && visited[x + up] == false) {
					visited[x + up] = true;
					arr[x + up] = arr[x] + 1;
					q.add(x + up);
				}
				
				if(x - down > 0 && visited[x - down] == false) {
					visited[x - down] = true;
					arr[x - down] = arr[x] + 1;
					q.add(x - down);
				}
			}
		
		bw.write(String.valueOf(visited[target] == false? "use the stairs" : String.valueOf(arr[target]-1)));
		bw.flush();
		bw.close();
	}

}