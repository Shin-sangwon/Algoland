import java.util.*;
import java.io.*;

public class Main {
	
	
	static String reverse(String str1) {
		String str2 = "";
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str1.length(); i++) {
			stack.push(str1.charAt(i));
		}
		
		while(!stack.isEmpty()) {
			str2 += stack.pop();
		}
		
		
		return str2;
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String ans = "";
		boolean flag = false;
		
		String tmp = br.readLine();
		tmp += " ";
		
		for(int i = 0; i < tmp.length(); i++) {
			ans += tmp.charAt(i);
			if(tmp.charAt(i) == '<') flag = true;
			
			if(tmp.charAt(i) == '>' && flag) {			
				sb.append(ans);
				ans = "";
				flag = false;
			}
			
			if(tmp.charAt(i) == ' ' && !flag) {
				ans = ans.substring(0, ans.length()-1);
				ans = reverse(ans);
				sb.append(ans+" ");
				ans = "";
			}
			
			if(tmp.charAt(i) == '<' && flag) {
				ans = ans.substring(0, ans.length()-1);
				ans = reverse(ans);
				sb.append(ans+"<");
				ans = "";
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}