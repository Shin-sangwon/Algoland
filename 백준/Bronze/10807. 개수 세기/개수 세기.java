import java.io.*;
import java.util.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int cnt = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int target = Integer.parseInt(br.readLine());
		
		while(st.hasMoreTokens()) {
			if(target == Integer.parseInt(st.nextToken())) ans++;
		}
		
		System.out.println(ans);
		
	}

}
