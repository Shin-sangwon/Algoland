import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> q = new LinkedList<>();
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= cnt; i++) {
			q.add(i);
		}
		
		ArrayList<Integer> al = new ArrayList<>();
		
		while(q.size() != 1) {
			al.add(q.peek());
			q.remove();
			q.add(q.poll());			
		}
		
		bw.write(String.valueOf((q.peek())));
		bw.flush();
		bw.close();
	}
}