import java.io.*;
import java.util.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<String> ll = new LinkedList<>();		
		ListIterator<String> iter = ll.listIterator();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			iter.add(str.substring(i, i+1));
		}
		
		
		int cursor = str.length()-1;
		
		
		int cnt = Integer.parseInt(br.readLine());
		while(cnt != 0) {
			cnt--;
			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp, " ");
			String tmp1 = st.nextToken();
			
			if(tmp1.equals("L") && iter.hasPrevious()) {
				iter.previous();
			}
			
			if(tmp1.equals("D") && iter.hasNext()) {
				iter.next();
			}
			
			if(tmp1.equals("B") && iter.hasPrevious()) {
				iter.previous();
				iter.remove();			
			}
			
			if(tmp1.equals("P")) {
				iter.add(st.nextToken());
			}
			
		}
		
		for(String x : ll) bw.write(x);
		bw.flush();
		
	}
}