import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void print() throws IOException {
		sb.append("<");
		for(int i = 0; i < al.size()-1; i++) {
			sb.append(al.get(i) + ", ");
		}
		sb.append(al.get(al.size()-1)).append(">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
				
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		while(al.size() != n) {
			int tmp = 0;
			if(q.isEmpty()) {
				break;
			}
			
			while(true) {
				if(tmp == k-1) {
					al.add(q.poll());
					break;
				}
				
				tmp++; q.add(q.poll());
			}	
		}
		
		print();
	}
}