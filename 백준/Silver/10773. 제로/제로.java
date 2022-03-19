import java.io.*;
import java.util.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int cnt = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < cnt; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp == 0) {
				s.pop();
			}else {
				s.push(tmp);
			}
		}
		
		for(int x : s) ans += x;
		
		System.out.println(ans);
		
	}
}
