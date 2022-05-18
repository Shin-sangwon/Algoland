import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int cnt1 = Integer.parseInt(st.nextToken());
		int cnt2 = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		while(cnt1-- != 0) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		while(cnt2-- != 0) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(al);
		
		for(int x : al) bw.write(x+" ");
		bw.flush();
		bw.close();
		br.close();
	}
}