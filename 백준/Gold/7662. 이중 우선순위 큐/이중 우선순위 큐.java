import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			int m = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			while(m-->0) {		
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				
				if(tmp.equals("I")) {
					int key = Integer.parseInt(st.nextToken());
					map.put(key, map.getOrDefault(key, 0)+1);
					continue;
				}
				
				int num = Integer.parseInt(st.nextToken());
				
				if(map.size() == 0) continue;
				else {
					if(num == 1) {
						int deleteNum = map.lastKey();
						if(map.get(deleteNum) == 1) map.remove(deleteNum);
						else {
							int getValue = map.get(deleteNum);
							map.remove(deleteNum);
							map.put(deleteNum, getValue-1);
						}
						continue;
					}
					
					int deleteNum = map.firstKey();
					if(map.get(deleteNum) == 1) map.remove(deleteNum);
					else {
						int getValue = map.get(deleteNum);
						map.remove(deleteNum);
						map.put(deleteNum, getValue-1);
					}				
				}	
			}
			if(map.size() == 0) {
				sb.append("EMPTY\n");
			}else {
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}