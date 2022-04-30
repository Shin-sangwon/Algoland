import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			map.put(tmp, map.getOrDefault(tmp, 1));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.get(tmp) == null) {
				bw.write(0+" ");
			}else {
				bw.write(map.get(tmp) + " ");
			}
		}
		
		bw.flush();
		bw.close();
		
	}
}