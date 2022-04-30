import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < cnt; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
		}
		
		int cnt1 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < cnt1; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.get(tmp) == null) {
				bw.write(0 + " ");
			}else {
				bw.write(map.get(tmp) + " ");
			}
		}
		bw.flush();
		bw.close();
			
	}
}