import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			
			int storeNum = Integer.parseInt(br.readLine());
			ArrayList<Node> stores = new ArrayList<>();
			boolean[] visited = new boolean[storeNum];
			
			//home
			st = new StringTokenizer(br.readLine());
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			Node home = new Node(homeX, homeY);
			
			for(int i = 0; i < storeNum; i++) {
				//편의점
				st = new StringTokenizer(br.readLine());
				int storeX = Integer.parseInt(st.nextToken());
				int storeY = Integer.parseInt(st.nextToken());
				stores.add(new Node(storeX, storeY));
			}
			
			// target
			st = new StringTokenizer(br.readLine());
			int festivalX = Integer.parseInt(st.nextToken());
			int festivalY = Integer.parseInt(st.nextToken());
			Node target = new Node(festivalX, festivalY);
			
			Queue<Node> queue = new LinkedList<>();
			queue.add(home);
			boolean flag = false;
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				if(Math.abs(node.x - target.x) + Math.abs(node.y - target.y) <= 1000) {
					flag = true;
					break;
				}
				
				for(int i = 0; i < stores.size(); i++) {
					
					if(visited[i]) continue;
					
					Node now = stores.get(i);
					
					if(Math.abs(node.x - now.x) + Math.abs(node.y - now.y) <= 1000) {
						queue.add(now);
						visited[i] = true;
					}
				}
			}
			
			sb.append(flag? "happy\n" : "sad\n");
			
		}
		
		System.out.println(sb);
	}

}
