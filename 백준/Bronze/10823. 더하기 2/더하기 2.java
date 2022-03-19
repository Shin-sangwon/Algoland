import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		String s = "";
		while(sc.hasNext()) {
			String str = sc.nextLine();
			s += str;	
		}
		StringTokenizer st = new StringTokenizer(s, ",");
		while(st.hasMoreTokens()) {
			ans += Integer.parseInt(st.nextToken());
		}
		System.out.println(ans);
	}
}