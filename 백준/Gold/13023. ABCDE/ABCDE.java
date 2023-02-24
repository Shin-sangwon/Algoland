import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph;
	static int n;
	static boolean flag;
	
	private static void dfs(boolean[] visited, int start, int cnt) {
		
		if(cnt == 5) {
			flag = true;
			return;
		
		}
		
		visited[start] = true;
		
		for(int x : graph.get(start)) {
			
			if(visited[x]) continue;
			visited[x] = true;
			dfs(visited, x, cnt + 1);
			visited[x] = false;
		}
		
		visited[start] = false;
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		while(m-->0) {
			
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		boolean visited[] = new boolean[n];
		flag = false;
		
		for(int i = 0; i < n && !flag; i++) {
			dfs(visited, i, 1);
			
		}
		
		System.out.println(flag? 1 : 0);
		

	}

}
