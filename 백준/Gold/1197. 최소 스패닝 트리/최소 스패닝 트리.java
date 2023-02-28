import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int v,e,arr[];
	
	static class Node{
		
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	private static void init() {
		arr = new int[v+1];
		for(int i = 1; i <= v; i++) arr[i] = i;
	}
	
	private static int find(int x) {
		
		if(arr[x] == x) return x;
		
		return arr[x] = find(arr[x]);
	}
	
	private static boolean union(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;
		
		arr[yRoot] = xRoot;
		
		return true;
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		init();
		
		Node[] nodeList = new Node[e];
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodeList[i] = new Node(from ,to, weight);
		}
		
		Arrays.sort(nodeList, (o1, o2) -> o1.weight - o2.weight);
		
		int count = 0;
		int totalWeight = 0;
		
		for(Node node : nodeList) {
			if(union(node.from, node.to)) {
				totalWeight += node.weight;
				if(count++ == v) break;
			}
		}
		
		System.out.println(totalWeight);
	}

}
