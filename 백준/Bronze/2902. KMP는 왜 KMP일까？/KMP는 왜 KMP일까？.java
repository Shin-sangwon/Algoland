import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "-");
		while(st.hasMoreTokens()) {
			System.out.print(st.nextToken().charAt(0));
		}
		
	}
}