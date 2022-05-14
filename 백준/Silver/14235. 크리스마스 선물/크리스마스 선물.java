import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-- != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp = Integer.parseInt(st.nextToken());
			
			if(tmp == 0) {
				if(pq.size() == 0) {
					bw.write("-1"+'\n');
				}else {
					bw.write(pq.poll()+""+'\n');
				}
			}else {
				for(int i = 0; i < tmp; i++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}