import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		
		int num;
		int diff;
		
		public Node(int num, int diff) {
			this.num = num;
			this.diff = diff;
		}

		@Override
		public int compareTo(Node o) {
			if(this.diff < o.diff) return -1;
            else if(this.diff == o.diff){
                if(this.num < o.num) return -1;
                else if (this.num > o. num)return 1;
                else return 0;
            }
            else return 1;
		}
		
	}
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		PriorityQueue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		int n = Integer.parseInt(br.readLine());
		
		while(n -- > 0) {
			st = new StringTokenizer(br.readLine());
			
			Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			minHeap.add(node);
			maxHeap.add(node);
		}
		
		n = Integer.parseInt(br.readLine());
		
		while(n --> 0) {
			
			st = new StringTokenizer(br.readLine());
			
			String tmp = st.nextToken();
			
			if(tmp.equals("add")) {
				
				Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
				minHeap.add(node);
				maxHeap.add(node);
				continue;
			}
			
			if(tmp.equals("recommend")) {
				
				if(Integer.parseInt(st.nextToken()) == 1) {
					sb.append(maxHeap.peek().num).append("\n");
					continue;
				}
				
				sb.append(minHeap.peek().num).append("\n");
				continue;
				
			}
			
			if(tmp.equals("solved")) {
				
				int num = Integer.parseInt(st.nextToken());
				
				for(Node x : minHeap) {
					if(x.num == num) {
						minHeap.remove(x);
						maxHeap.remove(x);
						break;
					}
				}
				
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		

	}

}
