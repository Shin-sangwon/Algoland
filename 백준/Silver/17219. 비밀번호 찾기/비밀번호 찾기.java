import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		HashMap<String, String> map = new HashMap<String, String>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num = Integer.parseInt(st.nextToken());
		int ans = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			String b = st.nextToken();
			map.put(a, b);
		}
		
		for(int i = 0; i < ans; i++) {
			bw.write(map.get(br.readLine()));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
			
}