import java.io.*;
import java.util.*;

public class Main {
	
	

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(str, ",");
		while(st.hasMoreTokens()) {
			ans += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(ans);
		br.close();
		
		
		
	}
}