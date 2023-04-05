import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//접시 n, 가짓 수 d, 연속 k, 쿠폰 c
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int answer = -1;
		/*
		 * 1. k개의 접시를 연속으로 먹을 수 있을 때
		 * 1.1 c가 포함되지 않았을 경우 return cnt + c
		 * 1.2 c가 포함되었을 경우, return cnt
		 *
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		int idx = 0;
		
		for(int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(br.readLine()));
			if(i == 0) idx = queue.peek();
		}
		
		
		int target = n + k;
		int cnt = 0;
		ArrayList<Integer> al = new ArrayList<>();
		while(target--> 0) {
			
			if(cnt != k) {
				int now = queue.poll();
				map.merge(now, 1, Integer::sum);
				cnt++;
				queue.add(now);
				al.add(now);
				continue;
			}
			
			if(cnt == k) {
								
				answer = map.containsKey(c)? Math.max(answer, map.size()) : Math.max(answer, map.size() + 1);
				
				if(map.get(idx) == 1) map.remove(idx);
				else map.put(idx, map.get(idx) - 1);
				
				idx = al.get(1);
				int now = queue.poll();
				map.merge(now, 1, Integer::sum);
				queue.add(now);
				al.remove(0);
				al.add(now);
				
			}
		}
		
		System.out.println(answer);

	}

}
