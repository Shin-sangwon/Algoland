import java.util.*; import java.math.*;

public class Main {
	
	static int n, m, start;
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + " ");
		for(int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = true;
		while(!q.isEmpty()) {
			int y = q.poll();
			System.out.print(y + " ");
			for(int i = 0; i < graph.get(y).size(); i++) {
				int z = graph.get(y).get(i);
				if(!visited[z]) {
					q.offer(z);
					visited[z] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); start = sc.nextInt();
		visited = new boolean[n+1];
		
		for(int i = 0; i < n+1; i++) graph.add(new ArrayList<Integer>());
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);			
		}
		
		for(int i = 1; i < n+1; i++) Collections.sort(graph.get(i));
		
		dfs(start); 
		Arrays.fill(visited, false); System.out.println(); 
		bfs(start);
	}

}