import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		ArrayList<String> al = new ArrayList<>();
		int ans = 0;
		int cnt[] = new int[2];
		HashMap<String, Integer> map = new HashMap<>();
	
		for(int i = 0; i < 2; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < cnt[0]; i++) {
			String tmp = br.readLine();
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
		}
		
		for(int i = 0; i < cnt[1]; i++) {
			String tmp = br.readLine();
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
		}
		
		for(String x : map.keySet()) {
			if(map.get(x) == 2) {
				al.add(x);
				ans++;
			}
		}
		Collections.sort(al);
		System.out.println(ans);
		for(String x : al) System.out.println(x);
	}
}