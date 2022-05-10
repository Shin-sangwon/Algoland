import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> ans = new ArrayList<>();
		
		int cnt = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		while(cnt-- != 0) {
			String tmp = br.readLine();
			map.put(tmp, map.getOrDefault(tmp,0)+1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key)>max) {
				max = map.get(key);
			}
		}
		
		for(String key : map.keySet()) {
			if(map.get(key) == max) {
				ans.add(key);
			}
		}
		
		Collections.sort(ans);
		bw.write(ans.get(0));
		bw.flush();
		bw.close();
		br.close();
		
	}

}