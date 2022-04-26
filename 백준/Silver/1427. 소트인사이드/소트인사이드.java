import java.util.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		ArrayList<String> ans = new ArrayList<>();
		
		for(int i = 0; i < str.length(); i++) {
			ans.add(str.substring(i, i+1));
		}
		
		Collections.sort(ans, Collections.reverseOrder());
		
		for(String x : ans) System.out.print(x);
		
	}

}