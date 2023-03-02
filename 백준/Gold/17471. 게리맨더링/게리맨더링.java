import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, answer, population[];
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> teamA, teamB;
	static boolean visited[];
	
	private static void combination(int cnt, int start, int r) {
		
		if(cnt == r) {
			
			teamA = new ArrayList<>();
			teamB = new ArrayList<>();
			//조합으로 나뉜 팀 분배해주기
			for(int i = 1; i <= n; i++) {
				if(visited[i]) teamA.add(i);
				else teamB.add(i);
			}
			
			if(!check()) return;
			
			int totalA = 0;
			int totalB = 0;
			
			for(int x : teamA) totalA += population[x];
			for(int x : teamB) totalB += population[x];
			
			int tmp = Math.abs(totalA - totalB);
			answer = Math.min(answer, Math.abs(totalA-totalB));
			

			return;
		}
		
		for(int i = start; i < n; i++) {
			
			visited[i] = true;
			combination(cnt + 1, i + 1, r);
			visited[i] = false;
		}
		
	}
	
	private static boolean check() {
		
		boolean[] checkA = new boolean[n+1];
		boolean[] checkB = new boolean[n+1];
		
		int start = teamA.get(0);
		checkA[start] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		//a팀 체크하기
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			for(int x : graph.get(now)) {
				if(checkA[x] || teamB.contains(x)) continue;
				queue.add(x);
				checkA[x] = true;
			}
		}
		
		//같은 지역구가 아님
		for(int x : teamA) {
			if(!checkA[x]) return false;
		}
		//b팀 체크하기
		queue.clear();
		start = teamB.get(0);
		checkB[start] = true;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			if(teamA.contains(now)) continue;
			
			for(int x : graph.get(now)) {
				if(checkB[x] || teamA.contains(x)) continue;
				queue.add(x);
				checkB[x] = true;
			}
		}
 		
		for(int x : teamB) {
			if(!checkB[x]) return false;
		}
		
		for(int i = 1; i <= n; i++) {
			
			if(!teamA.contains(i) && !checkB[i]) return false;
		}
		
		
		return true;
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		population = new int[n+1];
		answer = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= n; i++) { 
			
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < m; j++) {
				
				int tmp = Integer.parseInt(st.nextToken());
				
				graph.get(i).add(tmp);
				
			}
			
		}
		
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			combination(0, 1, i);
		}
		
		System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
		
	}

}
