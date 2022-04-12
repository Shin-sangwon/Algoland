import java.io.*;
import java.util.*;

public class Main {
	
	
	static boolean checker(String str) {
		
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		
		for(int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if(stack.isEmpty()) {
				stack.push(tmp);
			}else {
				if(stack.get(stack.size()-1) == tmp) {
					stack.pop();
				}else {
					stack.push(tmp);
				}
			}											
		}
		if(stack.isEmpty()) flag = true;
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		int ans = 0;
		while(cnt != 0) {
			cnt--;
			if(checker(br.readLine())) ans++;
		}
		
		System.out.println(ans);
	}

}