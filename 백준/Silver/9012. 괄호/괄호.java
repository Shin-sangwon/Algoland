import java.io.*;
import java.util.*;

public class Main {
	
	static boolean checker(String tmp) {
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		for(int i = 0; i < tmp.length(); i++) {
			if(tmp.charAt(i) == '(') {
				stack.push(tmp.charAt(i));
			}else {
				if(stack.isEmpty()) {
					flag = false;
					break;
				}else if(stack.get(stack.size()-1) == '(') {
					stack.pop();
				}
			}				
		}
		
		if(!stack.isEmpty()) flag = false;
		
		return flag;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
			
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt != 0) {
			cnt--;
			if(checker(br.readLine())) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
		
	}

}