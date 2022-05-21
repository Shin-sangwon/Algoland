import java.util.*;
import java.io.*;
import java.security.MessageDigest;

public class Main {
	
	static boolean isnumeric(String str) {
		
		try {
			Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 1;
		
		while(n-- != 0) {
			String tmp = br.readLine();
			map1.put(cnt, tmp);
			map2.put(tmp, cnt);
			cnt++;
		}
		
		while(m-- != 0) {
			String tmp = br.readLine();
			if(isnumeric(tmp)) {
				bw.write(map1.get(Integer.parseInt(tmp))+""+'\n');
			}else {
				bw.write(map2.get(tmp)+""+'\n');
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}