import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		for(int i = 0; i < Integer.parseInt(str); i++) {
			String tmp1 = br.readLine();
			String ans = "";
			StringTokenizer st = new StringTokenizer(tmp1, " ");
			while(st.hasMoreTokens()) {
				String tmp2 = st.nextToken();
				for(int j = tmp2.length()-1; j >= 0; j--) {
					ans += tmp2.charAt(j);
				}
				ans += " ";
			}
			System.out.println(ans);
			ans = "";
		}
	}
}