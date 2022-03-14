import java.util.*;


public class Main {
	
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void dfs(int x) {
		visited[x] = true;
		for(int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		visited = new boolean[n+1];
		for(int i = 0; i < n+1; i++) graph.add(new ArrayList<Integer>());
	
	
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i = 1; i < n+1; i++) Collections.sort(graph.get(i));
		dfs(1);
		int ans = -1;
		for(boolean x : visited) {
			if(x == true) ans++;
		}
		
		System.out.println(ans);
		
	}

}