import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;


public class Main {
	
	static int cnt = 0;
	
	static String round(int x) {
		String out = String.format("%.4f", ((double)x / (double) cnt) * 100.0);
		
		return out;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		String tmp;
		HashMap<String, Integer> map = new HashMap<>();
		
		
		while((tmp = br.readLine()) != null) {
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
			cnt++;
		}
		
		br.close();
		
		TreeMap<String, Integer> sortedMap = new TreeMap<>(map);
		
		
		for(Entry<String, Integer> entry : sortedMap.entrySet()) {
			bw.write(entry.getKey() + " " + round(entry.getValue()));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}