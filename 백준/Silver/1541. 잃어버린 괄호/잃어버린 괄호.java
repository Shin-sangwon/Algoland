import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int answer = 0;
		
		ArrayList<Integer> ans = new ArrayList<>();		
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			int x = 0;
			
			StringTokenizer parsing = new StringTokenizer(tmp, "+");
			while(parsing.hasMoreTokens()) {
				x += Integer.parseInt(parsing.nextToken());			
			}
			ans.add(x);
		}	
		
		if(ans.size() == 1) {
			bw.write(ans.get(0) + " ");
		}else {
			answer += ans.get(0);
			for(int i = 1; i < ans.size(); i++) {
				answer -= ans.get(i);
			}
			bw.write(answer + " ");
		}
		bw.flush();
		bw.close();
	}
}