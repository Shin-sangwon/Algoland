import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<String> ans = new ArrayList<>();
		boolean flag = true;
		
		while(flag) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				flag = false;
				break;
			}
			ArrayList<String> original = new ArrayList<>();
			ArrayList<String> trans = new ArrayList<>();
			while(tmp-- != 0) {	
				String str = br.readLine();				
				original.add(str);
				trans.add(str.toLowerCase());
			}
			Collections.sort(trans);
			for(int i = 0; i < trans.size(); i++) {
				if(trans.get(0).equals(original.get(i).toLowerCase())) {
					ans.add(original.get(i));
				}
			}
		}
		
		for(String x : ans) System.out.println(x);
	}
}