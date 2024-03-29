import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->  
			
			Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2)
		);
		
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp == 0) {
				
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				
				sb.append(pq.poll()).append("\n");
				continue;
			}
			
			pq.add(tmp);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
