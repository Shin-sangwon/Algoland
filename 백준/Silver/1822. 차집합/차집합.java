import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		
		StringTokenizer last = new StringTokenizer(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
				
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(last.nextToken());
			if(!set.contains(tmp)) {
				al.add(tmp);
			}
		}
		
		Collections.sort(al);
		
		if(al.size() == 0) {
			bw.write("0");
		}else {
			bw.write(al.size() +"" + '\n');
			for(int x : al) bw.write(x + " ");
		}
		
		bw.flush();
		bw.close();
	}

}