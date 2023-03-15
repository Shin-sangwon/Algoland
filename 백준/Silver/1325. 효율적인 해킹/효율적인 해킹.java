import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	static ArrayList<ArrayList<Integer>> graph;
	static int n, m;
	static int answer, hacked[];
	static boolean[] visited;
	
	private static void dfs(int i) {
		
		visited[i] = true;
		
		for(int x : graph.get(i)) {
			
			if(visited[x]) continue;
			hacked[x]++;
			dfs(x);
		}
		
		
	}
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        graph = new ArrayList<>();
        answer = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hacked = new int[n+1];
        
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        while(m-->0) {
        	st = new StringTokenizer(br.readLine());
        	
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	graph.get(start).add(end);
        }
        
        for(int i = 1; i <= n; i++) {
        	visited = new boolean[n+1];
        	dfs(i);
        }
        
        for(int i = 1; i <= n; i++) {
        	answer = Math.max(answer, hacked[i]);
        }
        
        for(int i = 1; i <= n; i++) {
        	if(hacked[i] == answer) sb.append(i + " ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}